#pragma once

#include <istream>
#include <cstdio>
#include <list>
#include <string>


/*
 *open db file
 *must close db file
 *@return db handler
 */
long aOpendDB(const char* strDBFile);

/**
 *close aOpendDB return handle
 */
long aCloseDB(long handle);

std::list<std::string> getAllSingleMain();
