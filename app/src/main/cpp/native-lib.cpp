#include <jni.h>
#include <csignal>

extern "C"
JNIEXPORT void JNICALL
Java_com_iansoft_crash_Firebase_MainActivity_crashNative(JNIEnv *env, jobject thiz) {
    raise(SIGABRT);
}
