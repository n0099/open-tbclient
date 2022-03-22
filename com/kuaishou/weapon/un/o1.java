package com.kuaishou.weapon.un;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes7.dex */
public abstract class o1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 2048;

    /* renamed from: b  reason: collision with root package name */
    public static final String f38934b = ".gz";
    public transient /* synthetic */ FieldHolder $fh;

    public o1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, file) == null) {
            a(file, true);
        }
    }

    public static void a(File file, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, file, z) == null) {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file.getPath() + f38934b);
            a(fileInputStream, fileOutputStream);
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            if (z) {
                file.delete();
            }
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65539, null, inputStream, outputStream) != null) {
            return;
        }
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(outputStream);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = inputStream.read(bArr, 0, 2048);
                if (read == -1) {
                    gZIPOutputStream.flush();
                    gZIPOutputStream.finish();
                    gZIPOutputStream.close();
                    return;
                }
                gZIPOutputStream.write(bArr, 0, read);
            }
        } catch (Exception unused2) {
            gZIPOutputStream2 = gZIPOutputStream;
            if (gZIPOutputStream2 != null) {
                try {
                    gZIPOutputStream2.close();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            if (gZIPOutputStream2 != null) {
                try {
                    gZIPOutputStream2.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            a(str, true);
        }
    }

    public static void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, null, str, z) == null) {
            a(new File(str), z);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:3|(3:4|5|(2:7|8))|(4:10|11|12|13)|14|15|16|17) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        ByteArrayInputStream byteArrayInputStream;
        byte[] bArr2;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            byte[] bArr3 = null;
            r0 = null;
            byteArrayOutputStream2 = null;
            ByteArrayOutputStream byteArrayOutputStream3 = null;
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception unused) {
                    bArr2 = null;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception unused2) {
                bArr2 = null;
                byteArrayInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayInputStream = null;
            }
            try {
                a(byteArrayInputStream, byteArrayOutputStream);
                bArr3 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused3) {
                }
            } catch (Exception unused4) {
                byte[] bArr4 = bArr3;
                byteArrayOutputStream3 = byteArrayOutputStream;
                bArr2 = bArr4;
                if (byteArrayOutputStream3 != null) {
                    try {
                        byteArrayOutputStream3.close();
                    } catch (Exception unused5) {
                    }
                }
                if (byteArrayInputStream != null) {
                    bArr3 = bArr2;
                    byteArrayInputStream.close();
                    return bArr3;
                }
                return bArr2;
            } catch (Throwable th3) {
                byteArrayOutputStream2 = byteArrayOutputStream;
                th = th3;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception unused6) {
                    }
                }
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused7) {
                    }
                }
                throw th;
            }
            byteArrayInputStream.close();
            return bArr3;
        }
        return (byte[]) invokeL.objValue;
    }

    public static void b(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, file) == null) {
            b(file, true);
        }
    }

    public static void b(File file, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, file, z) == null) {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file.getPath().replace(f38934b, ""));
            b(fileInputStream, fileOutputStream);
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            if (z) {
                file.delete();
            }
        }
    }

    public static void b(InputStream inputStream, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, inputStream, outputStream) == null) {
            GZIPInputStream gZIPInputStream = null;
            try {
                try {
                    GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = gZIPInputStream2.read(bArr, 0, 2048);
                            if (read == -1) {
                                break;
                            }
                            outputStream.write(bArr, 0, read);
                        }
                        gZIPInputStream2.close();
                        gZIPInputStream2.close();
                    } catch (Exception unused) {
                        gZIPInputStream = gZIPInputStream2;
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        gZIPInputStream = gZIPInputStream2;
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused3) {
                }
            } catch (Exception unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            b(str, true);
        }
    }

    public static void b(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, str, z) == null) {
            b(new File(str), z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0043, code lost:
        if (r1 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(byte[] bArr) {
        InterceptResult invokeL;
        ByteArrayInputStream byteArrayInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        b(byteArrayInputStream, byteArrayOutputStream2);
                        bArr = byteArrayOutputStream2.toByteArray();
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        byteArrayInputStream.close();
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        byteArrayOutputStream = byteArrayOutputStream2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception unused5) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused6) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused7) {
                byteArrayInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayInputStream = null;
            }
            try {
                byteArrayInputStream.close();
            } catch (Exception unused8) {
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }
}
