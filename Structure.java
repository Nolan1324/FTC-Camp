//The following line is automatically created when a new program is created
package org.firstinspires.ftc.teamcode;

//Import statments automatically created when hitting
// Alt+Enter after typing a new type of object (e.x. DcMotor, Servo)
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

//Register the program on the driver station with the name "Structure"
@TeleOp(name="Basic")

//The line below is a Class. A Class is what a program in Java is called. When a new program is created, it will always have the line "public class Name". For this Class, the name is "Structure"
// After that, the line is followed by brackets {}. Inside of the brackets is where all the code will be contained (since a Class is a just a program).

//When programming for FTC, there is one change we need to make to the Class line. After the name of the Class and before the '{', we must type "extends OpMode".
// The word "extends" means that this program is a "child" of another program. In our case, the program is a "child" of "OpMode". An OpMode is the name for an FTC program used to
// controll the robot. When one Class extends another, the child Class inheirits all of the properities of its parent. So, our "Structure" class essentially acts as an OpMode,
// which means it can control our robot. Without extending "OpMode", our class would have no knowledge of controlling a robot.
public class Structure extends OpMode {
    //The rest of our code will be inside the {}s after defining our class.

    //Below we are defining a "variable". In programming, a variable is an element that will store information. When creating a new variable in Java,
    //we want to specify the variables type, name, and in some cases its value. The syntax for this is "type name;" or "type name = value;". 
    //Here, we are creating a new DcMotor called "motor_1". We did not give it a value, because we will set its value later. Keep in mind that variable types are
    // case sensitive, so "dcmotor" is not a valid type. Names can be whatever you want, but the common convention is to use "camelCaseFormatting".
    //The semicolon at the end specifies that this is the end of a statment. When we created our class above, we did not need a semicolon, since it was above
    // block (i.e., uses {}) rather than a statment.
    DcMotor motor1;

    //This is another variable we created called "power". This time, the type of the variable is "double", which means it is a decimal. Also, this time we set the value to 0.75;
    // For more information about JAVA data types (not FTC exclusive), go to https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
    double power = 0.75;

    //Below we have defined a method called "init". A method in java is another word for a function. When defining a method, we start with an access type. For
    // your purposes, you will only need to use "public". Then, you specify what type of data the method will send back. "init" does not return any data, so we use
    // "void". Afterwards, we have the method name followed by parenthesis (). Usually, these contain parameters that the method will input. However, "init" does not take
    // any input. Finally, the method contains {}, similar to how our Class did. Like before, the brackets contain all of the code in the method.
	
    //After defining a method, you usually need to call it in order to use it. However, the "init" method is built into FTC programs, and will always be ran once
    // before starting the program.
    @Override
    public void init() {
        //Here we are giving data to the motor "motor1" that we defined earlier. This time, we do not need to specify the data type, since we already
	// did that earlier. The reason we defined the motor outside of the "init" method is because if defined here, no other methods would be able to access it.
	//In other words, the brackets would "trap" the variable in the "init" method if we defined it here. But, since it was not defined inside of a method, all
	// methods can use it, such as our "loop" method.
		
	//The data that we gave to our motor1 was the result of calling a method. The method that we called was hardwareMap.dcMotor.get(name). When calling a method,
	// first you type the name, follow it with (), and put the input inside of the parenthesis. In this case, our input is the name of a motor we assigned in
	// our phone's config file. The name is surrended by quotes because it is a string, a.k.a, text. If we had multiply inputs, the format would be method(input1, input2);
	//Once again, we end the statment with a semicolon.
        motor1 = hardwareMap.dcMotor.get("leftDrive");
    }

    //Below is another definition of a method. This time, it is called "loop". Loop is also built into FTC, and will be reptitivley called while the program runs.
    @Override
    public void loop() {
        //Some variable types have methods built inside of them. For instance, DcMotor variables have the "setPower" method built into them. To call a method built into
	// a variable, first type the variable's name (in this case, motor1), a period, the method name, and then () containing the input.
	//The setPower method inputs a double value, i.e. a decimal, between -1.0 and 1.0. We could just pass a raw double through the method, such as 0.0 to stop the motor.
	//However, in this example, we passed a variable "power" through the method that contains a double value.
        motor1.setPower(power);
    }
}
