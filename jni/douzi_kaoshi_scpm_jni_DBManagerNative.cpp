#include "douzi_kaoshi_scpm_jni_DBManagerNative.h"
#include "douziexam.h"

jlong JNICALL Java_douzi_kaoshi_scpm_jni_DBManagerNative_open_1db
  (JNIEnv *env, jclass cls, jstring jstrfile)
{
    const char* pStrFile = env->GetStringUTFChars( jstrfile, NULL);

	long 	rtn = aOpendDB(pStrFile);

	env->ReleaseStringUTFChars(jstrfile, pStrFile);

	return rtn;
}
