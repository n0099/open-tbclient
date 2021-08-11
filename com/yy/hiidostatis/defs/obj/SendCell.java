package com.yy.hiidostatis.defs.obj;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.NumberUtil;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.cipher.AesCipher;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes10.dex */
public class SendCell {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AES_KEY = "*&Hjkfa{{07";
    public static final int RANDOM_LEN = 10000;
    public transient /* synthetic */ FieldHolder $fh;
    public String content;
    public long expire;
    public long id;
    public int retry;
    public long timestamp;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendCell(String str, long j2) {
        this(0L, str, j2, 0, System.currentTimeMillis());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), (String) objArr2[1], ((Long) objArr2[2]).longValue(), ((Integer) objArr2[3]).intValue(), ((Long) objArr2[4]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private long createId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? ((this.timestamp + (this.expire * 1000)) * 10000) + ((long) (Math.random() * 10000.0d)) : invokeV.longValue;
    }

    public static SendCell loadFromFile(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, file)) != null) {
            return (SendCell) invokeL.objValue;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] readInputStream = Util.readInputStream(fileInputStream);
                long parseId = parseId(file.getName());
                long j2 = NumberUtil.getLong(readInputStream, 0);
                SendCell sendCell = new SendCell(parseId, new String(new AesCipher((file.getName() + AES_KEY).getBytes()).decrypt(readInputStream, 20, readInputStream.length - 20), "utf-8").trim(), NumberUtil.getInt(readInputStream, 8), NumberUtil.getInt(readInputStream, 16), j2);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return sendCell;
            } catch (Throwable th) {
                th = th;
                try {
                    L.debug("SendCell", th.getMessage(), new Object[0]);
                    return null;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static long parseId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                if (str.endsWith(".sec")) {
                    return Long.parseLong(str.substring(0, str.length() - 4));
                }
                return 0L;
            } catch (Throwable th) {
                L.debug("SendCell", th.getMessage(), new Object[0]);
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    private File randomFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, file)) == null) {
            String absolutePath = file.getAbsolutePath();
            StringBuilder sb = new StringBuilder(absolutePath.length() + 25);
            sb.append(absolutePath);
            sb.append("/");
            sb.append(this.id);
            sb.append(".sec");
            return new File(sb.toString());
        }
        return (File) invokeL.objValue;
    }

    public void deleteFile(File file) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, file) == null) || this.id == 0) {
            return;
        }
        String absolutePath = file.getAbsolutePath();
        StringBuilder sb = new StringBuilder(absolutePath.length() + 25);
        sb.append(absolutePath);
        sb.append("/");
        sb.append(this.id);
        sb.append(".sec");
        new File(sb.toString()).delete();
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.content : (String) invokeV.objValue;
    }

    public long getExpire() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.expire : invokeV.longValue;
    }

    public long getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.id : invokeV.longValue;
    }

    public int getRetry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.retry : invokeV.intValue;
    }

    public long getTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.timestamp : invokeV.longValue;
    }

    public int retryIncrease() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.retry + 1;
            this.retry = i2;
            return i2;
        }
        return invokeV.intValue;
    }

    public boolean saveToFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, file)) != null) {
            return invokeL.booleanValue;
        }
        File randomFile = randomFile(file);
        if (randomFile.exists()) {
            return true;
        }
        FileOutputStream fileOutputStream = null;
        try {
            byte[] encrypt = new AesCipher((randomFile.getName() + AES_KEY).getBytes()).encrypt(this.content.getBytes("utf-8"));
            FileOutputStream fileOutputStream2 = new FileOutputStream(randomFile);
            try {
                fileOutputStream2.write(NumberUtil.getBytes(this.timestamp));
                fileOutputStream2.write(NumberUtil.getBytes(this.expire));
                fileOutputStream2.write(NumberUtil.getBytes(this.retry));
                fileOutputStream2.write(encrypt);
                fileOutputStream2.flush();
                try {
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return true;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    th.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public SendCell(long j2, String str, long j3, int i2, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.content = str;
        this.retry = i2;
        this.expire = j3;
        this.timestamp = j4;
        this.id = j2 == 0 ? createId() : j2;
    }
}
