package grading;

import courses.ComponentWeightage;

/**
 * 
 * @version 1.0
 * @since 2018/11/12
 * @author Jason
 *
 */
public class ComponentResult implements IWeightedMarks
{
	private ComponentWeightage weightage;
	private int marks;
	
	public ComponentResult(ComponentWeightage weightage, int marks)
	{
		this.weightage = weightage;
		this.marks = marks;
	}
	public ComponentResult(ComponentWeightage weightage)
	{
		this.weightage = weightage;
		this.marks = 0;
	}
	
	public String getName()
	{
		return weightage.getName();
	}
	public int getWeightage()
	{
		return weightage.getWeightage();
	}
	
	public double getMarks()
	{
		return marks;
	}
	public void setMarks(int marks)
	{
		this.marks = marks;
	}
	
	@Override
	public double computeWeightedMarks()
	{
		return getWeightage() * marks / 100.0;
	}
	
	@Override
	public String toString()
	{
		return getName() + " (" + getWeightage() + "%): " + String.format("%.1f", marks);
	}
}
