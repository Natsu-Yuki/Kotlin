import java.io.*

fun main(args:Array<String>){

    deserialize()
}
fun serialize(){
    var student = Student("Tom",18)
    var file  =File("C:\\Users\\Natsu\\Desktop\\object.txt")
    var fo = FileOutputStream(file)
    var oos = ObjectOutputStream(fo)
    oos.writeObject(student)
    oos.close()
    fo.close()
}
fun deserialize(){
    var file  =File("C:\\Users\\Natsu\\Desktop\\object.txt")
//    fi(!file.exists()){
//        return@fi
//    }
    var fi = FileInputStream(file)
    var ois = ObjectInputStream(fi)
    var student:Student = ois.readObject() as Student
    println("student:$student name:${student.name} age:${student.age}")
    ois.close()
    fi.close()
}
fun writeFile(){
    var fw = FileWriter("C:\\Users\\Natsu\\Desktop\\file.txt")
    var bw  = BufferedWriter(fw)
    bw.write("hello world!\n")
    bw.write("hello kotlin")

    bw.close()
    fw.close()

}

fun readFile(){
    var fr = FileReader("C:\\Users\\Natsu\\Desktop\\file.txt")
    var br = BufferedReader(fr)
    var text = br.readLine()
    while (text!= null){
        println(text)
        text = br.readLine()
    }
    br.close()
    fr.close()
}
class Student(name:String,age:Int):Serializable{
    var name:String
    var age:Int
    init {
        this.age=age
        this.name=name
    }


}


