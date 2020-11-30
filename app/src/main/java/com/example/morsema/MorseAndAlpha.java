package com.example.morsema;

public class MorseAndAlpha {

    String strCourseHeader,typeCourse;
    String[] arrayMorse1 = new String[]{"-", "--", "--.", "--.-", "--.--"};
    String[] arrayAlpha1 = new String[]{"ต ฏ", "ม", "ก", "ผ", "ฮ"};
    String[] arrayMorse1_1 = new String[]{"-", "--", "--.", "--.."};
    String[] arrayAlpha1_1 = new String[]{"ต ฏ", "ม", "ก", "ซ"};
    String[] arrayMorse2 = new String[]{"-.","-.-","-.-.","-.-.."};
    String[] arrayMorse2_1 = new String[]{"-.","-.-","-.-.","-.-.-"};
    String[] arrayMorse2_2 = new String[]{"-.","-.-","-.--","-.--."};
    String[] arrayMorse2_3 = new String[]{"-.","-..","-...","-...-"};
    String[] arrayMorse2_4 = new String[]{"-.","-..","-..-","-..-."};
    String[] arrayMorse2_5 = new String[]{"-.","-..","-..-","-..--"};
    String[] arrayMorse3 = new String[]{".--",".--.",".--.."};
    String[] arrayMorse3_1 = new String[]{"-.",".---"};
    String[] arrayMorse4 = new String[]{".-.",".-.."};
    String[] arrayMorse4_1 = new String[]{".-.",".-.--"};
    String[] arrayMorse5 = new String[]{"..-."};
    String[] arrayMorse6 = new String[]{"...","....","----"};

    // Morse of vowel
    String[] vowelMorse1 = new String[]{".","..","..--","..--."};
    String[] vowelMorse2 = new String[]{".-",".-.-",".-...",".-..-"};
    String[] vowelMorse3 = new String[]{"---","...-."};
    String[] vowelMorse4 = new String[]{"...-."};
    // end of Morse vowel

    // Morse of tone mark

    String[] toneMarkMorse1 = new String[]{"..-","...-","--...",".-.-."};

    // end of morse tone mark
// Morse of Symbol
    String[] symbolMorse1 = new String[]{".-.-.-",".-...",".-..-."};
    String[] symbolMorse2 = new String[]{"-.--.","-.--.-"};
    String[] symbolMorse3 = new String[]{"--..--","---..."};
    String[] symbolMorse4 = new String[]{"-..-.","-...-","-....-"};
    String[] symbolMorse5 = new String[]{"..--..","..--.-"};
    String[] symbolMorse6 = new String[]{"-.-.--","-.-.-."};
    String[] symbolMorse7 = new String[]{".--.-.","...-..-",".----."};
    // end of Morse of symbol
 // Number of Morse
    String[]numberMorse1 = new String[]{".----","..---","...--","....-","....."};
    String[] numberMorse2 = new String[]{"-....","--...","---..","----.","-----"};
// end of number of Morse

    // declare morse of course 2_1 - 2_5
    String[] arrayAlpha2 = new String[]{"น ณ","ค ต ฆ","ข ฃ","ถ ฐ"};
    String[] arrayAlpha2_1 = new String[]{"น ณ","ค ต ฆ","ข ฃ","ฝ"};
    String[] arrayAlpha2_2 = new String[]{"น ณ","ค ต ฆ","ย","ง"};
    String[] arrayAlpha2_3 = new String[]{"น ณ","ด ฎ","บ","อ"};
    String[] arrayAlpha2_4 = new String[]{"น ณ","ด ฎ","ช ฌ","จ"};
    String[] arrayAlpha2_5 = new String[]{"น ณ","ด ฎ","ช ฌ","ท ธ ฑ ฒ"};
    String[] arrayAlpha3 = new String[]{"ว","ป","พ ภ"};
    String[] arrayAlpha3_1= new String[]{"ว","ญ"};
    String[] arrayAlpha4= new String[]{"ร","ล ฬ"};
    String[] arrayAlpha4_1= new String[]{"ร","ฤ ฤๅ"};
    String[] arrayAlpha5= new String[]{"ฟ"};
    String[] arrayAlpha6= new String[]{"ศ ษ ส","ห","ฉ"};

    // Alpha of vowel
    String[] vowelAlpha1= new String[]{"เอ","อี","อือ","อึอ"};
    String[] vowelAlpha2= new String[]{"อา","แอ","อะ","ไอ ใอ"};
    String[] vowelAlpha3= new String[]{"โอ","อู"};
    String[] vowelAlpha4= new String[]{"อำ"};
    // end of Alpha of vowel

    // Alpha of tone mark

    String[] toneMarkAlpha1 = new String[]{"ไม้เอก","ไม้โท","ไม้ตรี","ไม้จัตวา"};
    // end of alpha of tone mark

    // Alpha of Symbol
    String[] symbolAlpha1 = new String[]{".","&","\""};
    String[] symbolAlpha2 = new String[]{"(",")"};
    String[] symbolAlpha3 = new String[]{",",":"};
    String[] symbolAlpha4 = new String[]{"/","=","-"};
    String[] symbolAlpha5 = new String[]{"?","_"};
    String[] symbolAlpha6 = new String[]{"!",";"};
    String[] symbolAlpha7 = new String[]{"@","$","'"};
    // end of Alpha of symbol

    // Alpha of number
    String[] numberAlpha1 = new String[]{"1","2","3","4","5"};
    String[] numberAlpha2 = new String[]{"6","7","8","9","0"};
    // end of Alpha of Morse
    String course1 = "ต ฏ, ม, ก, ผ, ฮ";
    String course1_1 = "ต ฏ, ม, ก, ซ";
    String course2 = "น ณ, ค ต ฆ, ข ฃ, ถ ฐ";
    String course2_1 = "น ณ, ค ต ฆ, ข ฃ, ฝ";
    String course2_2 = "น ณ, ค ต ฆ, ย, ง";
    String course2_3 = "น ณ, ด ฎ, บ, อ";
    String course2_4 = "น ณ, ด ฎ, ช ฌ, จ";
    String course2_5 = "น ณ, ด ฎ, ช ฌ, ท ธ ฑ ฒ";
    String course3 = "ว, ป, พ ภ";
    String course3_1 = "ว, ญ";
    String course4 = "ร, ล ฬ";
    String course4_1 = "ร, ฤ ฤๅ";
    String course5 = "ฟ";
    String course6 = "ศ ษ ส, ห, ฉ";


    // course of vowel
    String vowelCourse1  = "เอ, อี,  อือ,  อึอ";
    String vowelCourse2  = "อา, แอ, อะ, ไอ ใอ";
    String vowelCourse3  = "โอ, อู";
    String vowelCourse4  = "อำ";
    // end of course of vowel

    // course of tone mark
    String toneMarkCourse1 = "ไม้เอก, ไม้โท, ไม้ตรี, ไม้จัตวา ";
    // end of course of tone mark

    // Symbol of course
    String symbolCourse1 = ".\t\t &\t\t \"";
    String symbolCourse2 = "(\t\t)";
    String symbolCourse3 = ",\t\t:\t\t";
    String symbolCourse4 = "/\t\t=\t\t-";
    String symbolCourse5 = "?\t\t_";
    String symbolCourse6 ="!\t\t;";
    String symbolCourse7 = "@\t\t$\t\t'\t\t";
    // end of symbol of course

    // Course of number
    String numberCourse1 = "1, 2, 3, 4, 5";
    String numberCourse2 = "6, 7, 8, 9, 0";
    // end of Course of number
    public MorseAndAlpha(String strCourseHeader,String typeCourse){
        this.strCourseHeader = strCourseHeader;
        this.typeCourse = typeCourse;

    }

    public String[] checkMorse() {
        if (typeCourse.equals("พยัญชนะ")) {
            switch (strCourseHeader) {
                case "บทเรียนที่ 1":
                    return arrayMorse1;
                case "บทเรียนที่ 1.1":
                    return arrayMorse1_1;
                case "บทเรียนที่ 2":
                    return arrayMorse2;
                case "บทเรียนที่ 2.1":
                    return arrayMorse2_1;
                case "บทเรียนที่ 2.2":
                    return arrayMorse2_2;
                case "บทเรียนที่ 2.3":
                    return arrayMorse2_3;
                case "บทเรียนที่ 2.4":
                    return arrayMorse2_4;
                case "บทเรียนที่ 2.5":
                    return arrayMorse2_5;
                case "บทเรียนที่ 3":
                    return arrayMorse3;
                case "บทเรียนที่ 3.1":
                    return arrayMorse3_1;
                case "บทเรียนที่ 4":
                    return arrayMorse4;
                case "บทเรียนที่ 4.1":
                    return arrayMorse4_1;
                case "บทเรียนที่ 5":
                    return arrayMorse5;
                case "บทเรียนที่ 6":
                    return arrayMorse6;
                default:
                    return null;
            }
        } else if (typeCourse.equals("สระ")) {
            switch (strCourseHeader) {
                case "บทเรียนที่ 1":
                    return vowelMorse1;
                case "บทเรียนที่ 2":
                    return vowelMorse2;
                case "บทเรียนที่ 3":
                    return vowelMorse3;
                case "บทเรียนที่ 4":
                    return vowelMorse4;
                default:
                    return null;
            }
        } else if (typeCourse.equals("วรรณยุกต์")) {
            switch (strCourseHeader) {
                case "บทเรียนที่ 1":
                    return toneMarkMorse1;
                default:
                    return null;
            } // end of if check type
        }else if(typeCourse.equals("เครื่องหมาย")) {
            switch (strCourseHeader) {
                case "บทเรียนที่ 1":
                    return symbolMorse1;
                case "บทเรียนที่ 2":
                    return symbolMorse2;
                case "บทเรียนที่ 3":
                    return symbolMorse3;
                case "บทเรียนที่ 4":
                    return symbolMorse4;
                case "บทเรียนที่ 5":
                    return symbolMorse5;
                case "บทเรียนที่ 6":
                    return symbolMorse6;
                case "บทเรียนที่ 7":
                    return symbolMorse7;
                default:
                    return null;
            }
        }else if(typeCourse.equals("ตัวเลข")) {
            switch (strCourseHeader) {
                case "บทเรียนที่ 1":
                    return numberMorse1;
                case "บทเรียนที่ 2":
                    return numberMorse2;
                default:
                    return null;
            }
        }else {
            return null;
        }

    } // end of check morse
    public String[] checkAlpha(){

        if(typeCourse.equals("พยัญชนะ")){
            switch(strCourseHeader){
                case "บทเรียนที่ 1": return arrayAlpha1;
                case "บทเรียนที่ 1.1": return arrayAlpha1_1;
                case "บทเรียนที่ 2": return arrayAlpha2;
                case "บทเรียนที่ 2.1": return arrayAlpha2_1;
                case "บทเรียนที่ 2.2": return arrayAlpha2_2;
                case "บทเรียนที่ 2.3": return arrayAlpha2_3;
                case "บทเรียนที่ 2.4": return arrayAlpha2_4;
                case "บทเรียนที่ 2.5": return arrayAlpha2_5;
                case "บทเรียนที่ 3": return arrayAlpha3;
                case "บทเรียนที่ 3.1": return arrayAlpha3_1;
                case "บทเรียนที่ 4": return arrayAlpha4;
                case "บทเรียนที่ 4.1": return arrayAlpha4_1;
                case "บทเรียนที่ 5": return arrayAlpha5;
                case "บทเรียนที่ 6": return arrayAlpha6;
                default:
                    return null;
            }
        }else if(typeCourse.equals("สระ")){
            switch(strCourseHeader){
                case "บทเรียนที่ 1": return vowelAlpha1;
                case "บทเรียนที่ 2": return vowelAlpha2;
                case "บทเรียนที่ 3": return vowelAlpha3;
                case "บทเรียนที่ 4": return vowelAlpha4;
                default:
                    return null;
            }
        }else if(typeCourse.equals("วรรณยุกต์")){
            switch(strCourseHeader){
                case "บทเรียนที่ 1": return toneMarkAlpha1;
                default:
                    return null;
            }
        }else if(typeCourse.equals("เครื่องหมาย")) {
            switch (strCourseHeader) {
                case "บทเรียนที่ 1":
                    return symbolAlpha1;
                case "บทเรียนที่ 2":
                    return symbolAlpha2;
                case "บทเรียนที่ 3":
                    return symbolAlpha3;
                case "บทเรียนที่ 4":
                    return symbolAlpha4;
                case "บทเรียนที่ 5":
                    return symbolAlpha5;
                case "บทเรียนที่ 6":
                    return symbolAlpha6;
                case "บทเรียนที่ 7":
                    return symbolAlpha7;
                default:
                    return null;
            }
        }else if(typeCourse.equals("ตัวเลข")) {
            switch (strCourseHeader) {
                case "บทเรียนที่ 1":
                    return numberAlpha1;
                case "บทเรียนที่ 2":
                    return numberAlpha2;
                default:
                    return null;
            }
        }else{
            return null;
        } // end of if check type


    } // end of check alphabet

    public String checkStringAlpha(){

        if(typeCourse.equals("พยัญชนะ")){
            switch(strCourseHeader){
                case "บทเรียนที่ 1": return course1;
                case "บทเรียนที่ 1.1": return course1_1;
                case "บทเรียนที่ 2": return course2;
                case "บทเรียนที่ 2.1": return course2_1;
                case "บทเรียนที่ 2.2": return course2_2;
                case "บทเรียนที่ 2.3": return course2_3;
                case "บทเรียนที่ 2.4": return course2_4;
                case "บทเรียนที่ 2.5": return course2_5;
                case "บทเรียนที่ 3": return course3;
                case "บทเรียนที่ 3.1": return course3_1;
                case "บทเรียนที่ 4": return course4;
                case "บทเรียนที่ 4.1": return course4_1;
                case "บทเรียนที่ 5": return course5;
                case "บทเรียนที่ 6": return course6;
                case "จบคอร์สพยัญชนะ": return "จบคอร์สพยัญชนะ";
                default:
                    return null;
            }
        }else if(typeCourse.equals("สระ")){
            switch(strCourseHeader){
                case "บทเรียนที่ 1": return vowelCourse1;
                case "บทเรียนที่ 2": return vowelCourse2;
                case "บทเรียนที่ 3": return vowelCourse3;
                case "บทเรียนที่ 4": return vowelCourse4;
                case "จบคอร์สสระ": return "จบคอร์สสระ";
                default:
                    return null;
            }
        }else if(typeCourse.equals("วรรณยุกต์")){
            switch(strCourseHeader) {
                case "บทเรียนที่ 1":
                    return toneMarkCourse1;
                case "จบคอร์สวรรณยุกต์":
                    return "จบคอร์สวรรณยุกต์";
                default:
                    return null;
            }
        }else if(typeCourse.equals("เครื่องหมาย")) {
            switch (strCourseHeader) {
                case "บทเรียนที่ 1":
                    return symbolCourse1;
                case "บทเรียนที่ 2":
                    return symbolCourse2;
                case "บทเรียนที่ 3":
                    return symbolCourse3;
                case "บทเรียนที่ 4":
                    return symbolCourse4;
                case "บทเรียนที่ 5":
                    return symbolCourse5;
                case "บทเรียนที่ 6":
                    return symbolCourse6;
                case "บทเรียนที่ 7":
                    return symbolCourse7;
                case "จบคอร์สเครื่องหมาย": return "จบคอร์สเครื่องหมาย";
                default:
                    return null;
            }
        }else if(typeCourse.equals("ตัวเลข")) {
            switch (strCourseHeader) {
                case "บทเรียนที่ 1":
                    return numberCourse1;
                case "บทเรียนที่ 2":
                    return numberCourse2;
                case "จบคอร์สตัวเลข": return "จบคอร์สตัวเลข";
                default:
                    return null;
            }
        }else{
            return null;
        } // end of if check type

    } // end fo check course

}
