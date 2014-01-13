#include <jni.h>
#include "douziexam.h"
#include "sqlite/sqlite3.h"
#include <list>

long aOpendDB(const char* strDBFile)
{
	sqlite3* pHandle = NULL;

	int rtn = sqlite3_open(strDBFile,&pHandle);

	if(SQLITE_OK != rtn)
	{
		return 0;
	}

	return (long)pHandle;
}

long aCloseDB(long handle)
{

	sqlite3 *db = (sqlite3*)handle;

	if(NULL == db)
	{
		return 0;
	}

	sqlite3_close(db);
}

std::list<std::string> getAllSingleMain()
{
	std::list<std::string> out_data;
	return out_data;
}

