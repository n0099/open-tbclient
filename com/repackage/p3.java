package com.repackage;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.nio.ByteBuffer;
import java.util.zip.InflaterInputStream;
/* loaded from: classes7.dex */
public class p3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final byte[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1944464443, "Lcom/repackage/p3$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1944464443, "Lcom/repackage/p3$a;");
                    return;
                }
            }
            a = new byte[32000];
        }

        /* JADX WARN: Not initialized variable reg: 1, insn: 0x0084: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:27:0x0084 */
        public static Pixmap a(j3 j3Var) {
            InterceptResult invokeL;
            Exception e;
            Closeable closeable;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, j3Var)) != null) {
                return (Pixmap) invokeL.objValue;
            }
            Closeable closeable2 = null;
            try {
                try {
                    DataInputStream dataInputStream = new DataInputStream(new InflaterInputStream(new BufferedInputStream(j3Var.m())));
                    try {
                        Pixmap pixmap = new Pixmap(dataInputStream.readInt(), dataInputStream.readInt(), Pixmap.Format.fromGdx2DPixmapFormat(dataInputStream.readInt()));
                        ByteBuffer m = pixmap.m();
                        m.position(0);
                        m.limit(m.capacity());
                        synchronized (a) {
                            while (true) {
                                int read = dataInputStream.read(a);
                                if (read > 0) {
                                    m.put(a, 0, read);
                                }
                            }
                        }
                        m.position(0);
                        m.limit(m.capacity());
                        i8.a(dataInputStream);
                        return pixmap;
                    } catch (Exception e2) {
                        e = e2;
                        throw new GdxRuntimeException("Couldn't read Pixmap from file '" + j3Var + "'", e);
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable2 = closeable;
                    i8.a(closeable2);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                i8.a(closeable2);
                throw th;
            }
        }
    }

    public static Pixmap a(j3 j3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, j3Var)) == null) ? a.a(j3Var) : (Pixmap) invokeL.objValue;
    }
}
