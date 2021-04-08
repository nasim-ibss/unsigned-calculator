#include <jni.h>
#include <string>
#include <cmath>

extern "C" JNIEXPORT jint JNICALL
Java_com_example_calculator_MainActivity_Add(JNIEnv* env, jobject  object, jint x, jint y){
    return x + y;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_calculator_MainActivity_Sub(JNIEnv* env, jobject  object, jint x, jint y){
    return x - y;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_calculator_MainActivity_Mul(JNIEnv* env, jobject  object, jint x, jint y){
    return x * y;
}

extern "C" JNIEXPORT jfloat JNICALL
Java_com_example_calculator_MainActivity_Dev(JNIEnv* env, jobject  object, jfloat x, jfloat y){
    return floor(100 *(x / y))/100;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_calculator_MainActivity_Rem(JNIEnv* env, jobject  object, jint x, jint y){
    return x % y;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_calculator_MainActivity_Pow(JNIEnv* env, jobject  object, jint x, jint y){
    return pow(x,y);
}