package com.facebook.cache.common;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public interface CacheErrorLogger {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class CacheErrorCategory {
        public static final /* synthetic */ CacheErrorCategory[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CacheErrorCategory DELETE_FILE;
        public static final CacheErrorCategory EVICTION;
        public static final CacheErrorCategory GENERIC_IO;
        public static final CacheErrorCategory OTHER;
        public static final CacheErrorCategory READ_DECODE;
        public static final CacheErrorCategory READ_FILE;
        public static final CacheErrorCategory READ_FILE_NOT_FOUND;
        public static final CacheErrorCategory READ_INVALID_ENTRY;
        public static final CacheErrorCategory WRITE_CALLBACK_ERROR;
        public static final CacheErrorCategory WRITE_CREATE_DIR;
        public static final CacheErrorCategory WRITE_CREATE_TEMPFILE;
        public static final CacheErrorCategory WRITE_ENCODE;
        public static final CacheErrorCategory WRITE_INVALID_ENTRY;
        public static final CacheErrorCategory WRITE_RENAME_FILE_OTHER;
        public static final CacheErrorCategory WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
        public static final CacheErrorCategory WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
        public static final CacheErrorCategory WRITE_UPDATE_FILE_NOT_FOUND;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2110133585, "Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2110133585, "Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;");
                    return;
                }
            }
            READ_DECODE = new CacheErrorCategory("READ_DECODE", 0);
            READ_FILE = new CacheErrorCategory("READ_FILE", 1);
            READ_FILE_NOT_FOUND = new CacheErrorCategory("READ_FILE_NOT_FOUND", 2);
            READ_INVALID_ENTRY = new CacheErrorCategory("READ_INVALID_ENTRY", 3);
            WRITE_ENCODE = new CacheErrorCategory("WRITE_ENCODE", 4);
            WRITE_CREATE_TEMPFILE = new CacheErrorCategory("WRITE_CREATE_TEMPFILE", 5);
            WRITE_UPDATE_FILE_NOT_FOUND = new CacheErrorCategory("WRITE_UPDATE_FILE_NOT_FOUND", 6);
            WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND = new CacheErrorCategory("WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND", 7);
            WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND = new CacheErrorCategory("WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND", 8);
            WRITE_RENAME_FILE_OTHER = new CacheErrorCategory("WRITE_RENAME_FILE_OTHER", 9);
            WRITE_CREATE_DIR = new CacheErrorCategory("WRITE_CREATE_DIR", 10);
            WRITE_CALLBACK_ERROR = new CacheErrorCategory("WRITE_CALLBACK_ERROR", 11);
            WRITE_INVALID_ENTRY = new CacheErrorCategory("WRITE_INVALID_ENTRY", 12);
            DELETE_FILE = new CacheErrorCategory("DELETE_FILE", 13);
            EVICTION = new CacheErrorCategory("EVICTION", 14);
            GENERIC_IO = new CacheErrorCategory("GENERIC_IO", 15);
            CacheErrorCategory cacheErrorCategory = new CacheErrorCategory("OTHER", 16);
            OTHER = cacheErrorCategory;
            $VALUES = new CacheErrorCategory[]{READ_DECODE, READ_FILE, READ_FILE_NOT_FOUND, READ_INVALID_ENTRY, WRITE_ENCODE, WRITE_CREATE_TEMPFILE, WRITE_UPDATE_FILE_NOT_FOUND, WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND, WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND, WRITE_RENAME_FILE_OTHER, WRITE_CREATE_DIR, WRITE_CALLBACK_ERROR, WRITE_INVALID_ENTRY, DELETE_FILE, EVICTION, GENERIC_IO, cacheErrorCategory};
        }

        public CacheErrorCategory(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CacheErrorCategory valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CacheErrorCategory) Enum.valueOf(CacheErrorCategory.class, str) : (CacheErrorCategory) invokeL.objValue;
        }

        public static CacheErrorCategory[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CacheErrorCategory[]) $VALUES.clone() : (CacheErrorCategory[]) invokeV.objValue;
        }
    }

    void logError(CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th);
}
