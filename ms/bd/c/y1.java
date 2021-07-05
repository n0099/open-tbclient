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
@Keep
@JProtect
/* loaded from: classes10.dex */
public class y1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static y1 f76116a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f76117b;

    /* renamed from: c  reason: collision with root package name */
    public List<Integer> f76118c;

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
        this.f76117b = null;
        this.f76118c = new ArrayList();
        this.f76117b = context;
    }

    public static y1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f76116a == null) {
                synchronized (y1.class) {
                    if (f76116a == null) {
                        f76116a = new y1(context);
                    }
                }
            }
            return f76116a;
        }
        return (y1) invokeL.objValue;
    }

    public String a() {
        int i2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return (String) invokeV.objValue;
        }
        while (true) {
            char c2 = 15;
            while (true) {
                switch (c2) {
                    case '\r':
                        break;
                    case 14:
                        try {
                            synchronized (this) {
                                i2 = b();
                            }
                        } catch (Exception unused) {
                            i2 = -1;
                        }
                        return "" + i2;
                    case 15:
                    default:
                        c2 = 14;
                }
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
            return invokeV.intValue;
        }
        Intent registerReceiver = this.f76117b.registerReceiver(null, new IntentFilter((String) h.a(16777217, 0, 0L, "4790d2", new byte[]{36, 59, 78, 86, 84, 44, 51, 88, 97, 110, 49, 48, 68, 80, 21, 36, 52, 2, 97, 111, 43, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, 104, Constants.SHORT_PING_CMD_TYPE, 111, 17, 18, 36, 81, 95, 6, 29, 107, 106, 124, 0, 19})));
        if (registerReceiver == null) {
            return -1;
        }
        int intExtra = registerReceiver.getIntExtra((String) h.a(16777217, 0, 0L, "be3bd2", new byte[]{ByteCompanionObject.MAX_VALUE, 98, 86, 19, 87}), -1);
        int intExtra2 = registerReceiver.getIntExtra((String) h.a(16777217, 0, 0L, "25bdb4", new byte[]{48, 52, 16, 28, 88}), -1);
        char c2 = 19;
        while (true) {
            switch (c2) {
                case 18:
                case 19:
                    c2 = 20;
                case 20:
                default:
                    return Math.round(((intExtra / intExtra2) * 100.0f) * 10.0f) / 10;
            }
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Intent registerReceiver = this.f76117b.registerReceiver(null, new IntentFilter((String) h.a(16777217, 0, 0L, "478272", new byte[]{36, 59, 79, 84, 7, 44, 51, 88, 96, 108, 49, 48, 69, 82, 70, 36, 52, 2, 96, 109, 43, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, 105, 103, 60, 17, 18, 36, 80, 93, 6, 29, 106, 104, 47, 0, 19})));
            if (registerReceiver == null) {
                return -1;
            }
            int intExtra = registerReceiver.getIntExtra((String) h.a(16777217, 0, 0L, "f37076", new byte[]{100, 37, 69, 80, 29, 50}), -1);
            return (intExtra == 2 || intExtra == 5) ? 1 : 0;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Intent registerReceiver = this.f76117b.registerReceiver(null, new IntentFilter((String) h.a(16777217, 0, 0L, "e2156b", new byte[]{LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 62, 70, 83, 6, 124, 98, 93, 105, 107, 96, 53, 76, 85, 71, 116, Constants.SHORT_PING_CMD_TYPE, 7, 105, 106, 122, 126, 96, 96, 61, 65, 67, PublicSuffixDatabase.EXCEPTION_MARKER, 89, 90, 87, 24, 99, 111, 46, 80, 66})));
            if (registerReceiver == null) {
                return -1;
            }
            return registerReceiver.getIntExtra((String) h.a(16777217, 0, 0L, "744526", new byte[]{54, 58, 82, 70, 10, 36, 48}), -1);
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
        monitor-enter(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0019, code lost:
        r0 = d();
        r1 = b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
        monitor-exit(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
        r0 = (r0 * 10000) + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002b, code lost:
        r0 = -10001;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0004, code lost:
        continue;
     */
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Integer e() {
        int i2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048580, this)) != null) {
            return (Integer) invokeV.objValue;
        }
        while (true) {
            char c2 = '_';
            char c3 = '_';
            while (true) {
                switch (c2) {
                    case '^':
                        if (c3 == '\'') {
                            break;
                        }
                        break;
                    case '_':
                        switch (c3) {
                            case '_':
                                c2 = '^';
                                c3 = '}';
                        }
                        break;
                    case '`':
                        switch (c3) {
                            case '8':
                                c2 = '^';
                                c3 = '}';
                        }
                        break;
                    default:
                        c2 = '^';
                        c3 = '}';
                }
            }
        }
        return Integer.valueOf(i2);
    }

    public void f() {
        Integer e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (e2 = e()) == null) {
            return;
        }
        this.f76118c.add(e2);
        try {
            int size = this.f76118c.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.f76118c.subList(size - 10, size));
                this.f76118c.clear();
                this.f76118c = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized int[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                int size = this.f76118c.size();
                if (size <= 0) {
                    return new int[0];
                }
                if (size == 1) {
                    return new int[]{this.f76118c.get(0).intValue()};
                }
                List<Integer> list = this.f76118c;
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
}
