LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := douziexam
LOCAL_SRC_FILES := douziexam.cpp
LOCAL_SRC_FILES += sqlite/sqlite3.c

include $(BUILD_SHARED_LIBRARY)
