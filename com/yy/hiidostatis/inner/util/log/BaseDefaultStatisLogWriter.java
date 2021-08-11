package com.yy.hiidostatis.inner.util.log;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes10.dex */
public class BaseDefaultStatisLogWriter implements IBaseStatisLogWriter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_LEN = 4194304;
    public static final int MAX_LOG_SIZE = 33554432;
    public static final int MIN_LOG_SIZE = 262144;
    public transient /* synthetic */ FieldHolder $fh;
    public FileWriter fileWriter;
    public boolean isFileExist;
    public AtomicLong length;
    public String mFilePath;
    public int mLogMaxLen;
    public final boolean mWriteDebugLog;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseDefaultStatisLogWriter(String str, boolean z) {
        this(str, 4194304, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private FileWriter getFileWriter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.fileWriter != null && this.length.get() < this.mLogMaxLen) {
                return this.fileWriter;
            }
            synchronized (this) {
                if (this.fileWriter != null && this.length.get() < this.mLogMaxLen) {
                    return this.fileWriter;
                }
                if (this.fileWriter != null) {
                    try {
                        this.fileWriter.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                try {
                    File file = new File(this.mFilePath);
                    if (file.length() > this.mLogMaxLen) {
                        File file2 = new File(this.mFilePath + "_pre.txt");
                        file2.delete();
                        if (!file.renameTo(file2) && !file.delete()) {
                            return null;
                        }
                        file = new File(this.mFilePath);
                    }
                    this.length.set(file.length());
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    if (file.canWrite()) {
                        FileWriter fileWriter = new FileWriter(file, true);
                        this.fileWriter = fileWriter;
                        return fileWriter;
                    }
                    return null;
                } catch (IOException unused) {
                    return null;
                }
            }
        }
        return (FileWriter) invokeV.objValue;
    }

    private boolean writeLogOrThrow(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (str != null && str.length() != 0) {
                try {
                    FileWriter fileWriter = getFileWriter();
                    this.fileWriter = fileWriter;
                    if (fileWriter != null) {
                        fileWriter.write(str);
                        this.fileWriter.write(StringUtils.LF);
                        this.length.addAndGet(str.length() + 1);
                        this.fileWriter.flush();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.yy.hiidostatis.inner.util.log.IBaseStatisLogWriter
    public boolean outputDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mWriteDebugLog : invokeV.booleanValue;
    }

    @Override // com.yy.hiidostatis.inner.util.log.IBaseStatisLogWriter
    public void write(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            writeLogOrThrow(str);
        }
    }

    public BaseDefaultStatisLogWriter(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLogMaxLen = 4194304;
        this.isFileExist = false;
        this.fileWriter = null;
        this.length = new AtomicLong(0L);
        this.mFilePath = str;
        int min = Math.min(i2, 33554432);
        this.mLogMaxLen = min;
        this.mLogMaxLen = Math.max(min, 262144);
        this.mWriteDebugLog = z;
    }
}
