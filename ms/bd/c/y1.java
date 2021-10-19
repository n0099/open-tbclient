package ms.bd.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.JProtect;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
@Keep
@JProtect
/* loaded from: classes2.dex */
public class y1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static y1 f79698c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f79699a;

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f79700b;

    public y1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f79699a = null;
        this.f79700b = new ArrayList();
        this.f79699a = context;
    }

    public static y1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f79698c == null) {
                synchronized (y1.class) {
                    if (f79698c == null) {
                        f79698c = new y1(context);
                    }
                }
            }
            return f79698c;
        }
        return (y1) invokeL.objValue;
    }

    public void a() {
        Integer f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (f2 = f()) == null) {
            return;
        }
        this.f79700b.add(f2);
        try {
            int size = this.f79700b.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.f79700b.subList(size - 10, size));
                this.f79700b.clear();
                this.f79700b = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Intent registerReceiver = this.f79699a.registerReceiver(null, new IntentFilter((String) h.a(16777217, 0, 0L, "478272", new byte[]{36, 59, 79, 84, 7, 44, 51, 88, 96, 108, 49, 48, 69, 82, 70, 36, 52, 2, 96, 109, 43, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, 105, 103, 60, 17, 18, 36, 80, 93, 6, 29, 106, 104, 47, 0, 19})));
            if (registerReceiver == null) {
                return -1;
            }
            int intExtra = registerReceiver.getIntExtra((String) h.a(16777217, 0, 0L, "f37076", new byte[]{100, 37, 69, 80, 29, 50}), -1);
            return (intExtra == 2 || intExtra == 5) ? 1 : 0;
        }
        return invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
            return invokeV.intValue;
        }
        Intent registerReceiver = this.f79699a.registerReceiver(null, new IntentFilter((String) h.a(16777217, 0, 0L, "4790d2", new byte[]{36, 59, 78, 86, 84, 44, 51, 88, 97, 110, 49, 48, 68, 80, 21, 36, 52, 2, 97, 111, 43, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, 104, Constants.SHORT_PING_CMD_TYPE, 111, 17, 18, 36, 81, 95, 6, 29, 107, 106, 124, 0, 19})));
        if (registerReceiver == null) {
            return -1;
        }
        int intExtra = registerReceiver.getIntExtra((String) h.a(16777217, 0, 0L, "be3bd2", new byte[]{ByteCompanionObject.MAX_VALUE, 98, 86, 19, 87}), -1);
        int intExtra2 = registerReceiver.getIntExtra((String) h.a(16777217, 0, 0L, "25bdb4", new byte[]{48, 52, 16, 28, 88}), -1);
        while (true) {
            char c2 = 20;
            while (true) {
                switch (c2) {
                    case 18:
                        break;
                    case 19:
                        return Math.round(((intExtra / intExtra2) * 100.0f) * 10.0f) / 10;
                    case 20:
                    default:
                        c2 = 19;
                }
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Intent registerReceiver = this.f79699a.registerReceiver(null, new IntentFilter((String) h.a(16777217, 0, 0L, "e2156b", new byte[]{LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 62, 70, 83, 6, 124, 98, 93, 105, 107, 96, 53, 76, 85, 71, 116, Constants.SHORT_PING_CMD_TYPE, 7, 105, 106, 122, 126, 96, 96, 61, 65, 67, PublicSuffixDatabase.EXCEPTION_MARKER, 89, 90, 87, 24, 99, 111, 46, 80, 66})));
            if (registerReceiver == null) {
                return -1;
            }
            return registerReceiver.getIntExtra((String) h.a(16777217, 0, 0L, "744526", new byte[]{54, 58, 82, 70, 10, 36, 48}), -1);
        }
        return invokeV.intValue;
    }

    public synchronized int[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                int size = this.f79700b.size();
                if (size <= 0) {
                    return new int[0];
                }
                if (size == 1) {
                    return new int[]{this.f79700b.get(0).intValue()};
                }
                List<Integer> list = this.f79700b;
                int i2 = size - 10;
                if (i2 <= 0) {
                    i2 = 0;
                }
                List<Integer> subList = list.subList(i2, size);
                int[] iArr = new int[subList.size()];
                for (int i3 = 0; i3 < subList.size(); i3++) {
                    iArr[i3] = subList.get(i3).intValue();
                }
                return iArr;
            }
        }
        return (int[]) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0015 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Integer f() {
        int i2;
        int d2;
        int c2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048581, this)) != null) {
            return (Integer) invokeV.objValue;
        }
        while (true) {
            char c3 = '^';
            char c4 = ExtendedMessageFormat.END_FE;
            while (true) {
                switch (c3) {
                    case '^':
                        c3 = '_';
                        c4 = '_';
                    case '_':
                        switch (c4) {
                            case '_':
                                try {
                                    synchronized (this) {
                                        d2 = d();
                                        c2 = c();
                                    }
                                    i2 = (d2 * 10000) + c2;
                                } catch (Exception unused) {
                                    i2 = -10001;
                                }
                                return Integer.valueOf(i2);
                            case '^':
                            case '`':
                                c3 = '_';
                                c4 = '_';
                        }
                        break;
                }
                switch (c4) {
                    case '7':
                    case '9':
                        break;
                    case '8':
                        break;
                    default:
                        c3 = '_';
                        c4 = '_';
                }
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public java.lang.String g() {
        /*
            r4 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = ms.bd.c.y1.$ic
            if (r0 != 0) goto L36
        L4:
            r0 = 92
        L6:
            r1 = 14
        L8:
            switch(r1) {
                case 13: goto L2f;
                case 14: goto L31;
                case 15: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L6
        Lc:
            switch(r0) {
                case 94: goto L31;
                case 95: goto L10;
                case 96: goto L31;
                default: goto Lf;
            }
        Lf:
            goto L31
        L10:
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            int r0 = r4.c()     // Catch: java.lang.Throwable -> L17
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L17
            goto L1d
        L17:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L17
            throw r0     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
        L1a:
            r0 = move-exception
            throw r0
        L1c:
            r0 = -1
        L1d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ""
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            return r0
        L2f:
            r1 = 72
        L31:
            r1 = 15
            r0 = 95
            goto L8
        L36:
            r2 = r0
            r3 = 1048582(0x100006, float:1.469376E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeV(r3, r4)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bd.c.y1.g():java.lang.String");
    }
}
