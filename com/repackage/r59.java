package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.repackage.t89;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class r59 extends q59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int h;
    public int i;
    public int j;
    public l59 k;
    public long l;
    public boolean m;
    public boolean n;
    public m59 o;
    public boolean p;
    public boolean q;
    public n59 r;

    /* loaded from: classes7.dex */
    public class a implements t89.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ r59 b;

        public a(r59 r59Var, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r59Var, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r59Var;
            this.a = sb;
        }

        @Override // com.repackage.t89.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.repackage.t89.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(",createMuteAudio ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                w89.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.repackage.t89.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                w89.j("FFmpegChain", " createMuteAudio 进度i1 = " + i2);
                r59 r59Var = this.b;
                r59Var.i((int) (((float) r59Var.i) + (((((float) i2) * 1.0f) / 100.0f) * 10.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements t89.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ r59 b;

        public b(r59 r59Var, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r59Var, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r59Var;
            this.a = sb;
        }

        @Override // com.repackage.t89.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.repackage.t89.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(",concatAudio ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                w89.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.repackage.t89.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                w89.j("FFmpegChain", " concatMuteAudio 进度i1 = " + i2);
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements t89.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ l59 b;
        public final /* synthetic */ r59 c;

        public c(r59 r59Var, StringBuilder sb, l59 l59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r59Var, sb, l59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r59Var;
            this.a = sb;
            this.b = l59Var;
        }

        @Override // com.repackage.t89.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.c) {
                    this.c.notifyAll();
                }
            }
        }

        @Override // com.repackage.t89.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(",dealAudioPlayData ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                l59 l59Var = this.b;
                if (l59Var != null && l59Var.a() != null) {
                    this.a.append(",audioformat:");
                    this.a.append(this.b.a().f());
                    this.a.append(",audiopath:");
                    this.a.append(this.b.a().h());
                }
                w89.j("FFmpegChain", sb2);
                synchronized (this.c) {
                    this.c.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.repackage.t89.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                w89.j("FFmpegChain", " dealAudioPlayData 进度i1 = " + i2);
                r59 r59Var = this.c;
                r59Var.i(r59Var.i + ((int) ((((((float) (this.c.j + (-1))) + ((((float) i2) * 1.0f) / 100.0f)) * 1.0f) / ((float) this.c.h)) * 60.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements t89.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ r59 b;

        public d(r59 r59Var, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r59Var, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r59Var;
            this.a = sb;
        }

        @Override // com.repackage.t89.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.repackage.t89.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("concatAudio ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                w89.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.repackage.t89.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                w89.j("FFmpegChain", " concatAudio 进度i1 = " + i2);
                r59 r59Var = this.b;
                r59Var.i((int) (((float) r59Var.i) + (((((float) i2) * 1.0f) / 100.0f) * 10.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements t89.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ r59 b;

        public e(r59 r59Var, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r59Var, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r59Var;
            this.a = sb;
        }

        @Override // com.repackage.t89.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.repackage.t89.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("mixAudio ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                w89.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.repackage.t89.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                w89.j("FFmpegChain", " mixAudio 进度i1 = " + i2);
                r59 r59Var = this.b;
                r59Var.i((int) (((float) r59Var.i) + (((((float) i2) * 1.0f) / 100.0f) * 20.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    public r59() {
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

    public final void A() {
        String str;
        String a2;
        m59 m59Var;
        l59 l59Var;
        m59 m59Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            l59 l59Var2 = this.k;
            boolean z = l59Var2 != null && l59Var2.c();
            if (!z && ((m59Var2 = this.o) == null || !FileUtils.isExists(m59Var2.h()))) {
                g("nosource to create mute audio");
                return;
            }
            if (z && (m59Var = this.o) != null && (l59Var = this.k) != null && !m59Var.equals(l59Var.a())) {
                z = false;
            }
            StringBuilder sb = new StringBuilder();
            str = "";
            if (!z) {
                try {
                } catch (Throwable th) {
                    sb.append(th.getMessage());
                }
                if (this.o == null) {
                    return;
                }
                str = a(this.o.h(), "_mute.aac");
                l79.l(this.o.h(), str, -1, -1, 0.0f, -1, 0.0f, -1.0f, false, new a(this, sb));
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e2) {
                    sb.append(e2.getMessage());
                }
                if (FileUtils.isExists(a2) && TextUtils.isEmpty(sb.toString())) {
                    w89.j("FFmpegChain", "createconcatMuteAudio 生成成功");
                    this.k = new l59(new AudioPlayData(a2, 0, -1, 1.0f));
                    return;
                }
                g(sb.toString());
            }
            l59 l59Var3 = this.k;
            str = l59Var3 != null ? l59Var3.a().h() : "";
            i(this.i + 10);
            if (FileUtils.isExists(str) && TextUtils.isEmpty(sb.toString())) {
                w89.j("FFmpegChain", "createMuteAudio 生成成功");
                l59 l59Var4 = new l59(new AudioPlayData(str, 0, -1, 1.0f));
                this.k = l59Var4;
                if (l59Var4.a() == null || this.k.a().e() <= 0) {
                    return;
                }
                long e3 = this.k.a().e();
                long j = this.l;
                if (e3 >= j) {
                    return;
                }
                int e4 = (int) ((j / this.k.a().e()) + 1);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < e4; i++) {
                    arrayList.add(str);
                }
                a2 = a(str, "_concat.aac");
                l79.b(arrayList, a2, this.g, new b(this, sb), false, true);
                try {
                } catch (InterruptedException e5) {
                    sb.append(e5.getMessage());
                }
                synchronized (this) {
                    wait();
                    if (FileUtils.isExists(a2)) {
                        w89.j("FFmpegChain", "createconcatMuteAudio 生成成功");
                        this.k = new l59(new AudioPlayData(a2, 0, -1, 1.0f));
                        return;
                    }
                }
            }
            g(sb.toString());
        }
    }

    public final void B(n59 n59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n59Var) == null) {
            if (n59Var == null || b99.e(n59Var.c())) {
                g("concatAudio tempDataForOutPut data error");
                return;
            }
            List<p59> c2 = n59Var.c();
            StringBuilder sb = new StringBuilder();
            for (p59 p59Var : c2) {
                if (!b99.e(p59Var.a())) {
                    ArrayList arrayList = new ArrayList();
                    for (l59 l59Var : p59Var.a()) {
                        if (l59Var.b() != null) {
                            arrayList.add(l59Var.b().audioPath);
                        }
                    }
                    if (!b99.e(arrayList)) {
                        String str = this.g;
                        if (TextUtils.isEmpty(str)) {
                            str = FileUtils.getParentDir((String) arrayList.get(0));
                        }
                        String str2 = str + System.currentTimeMillis() + "_trackconcat.aac";
                        l79.b(arrayList, str2, this.g, new d(this, sb), false, true);
                        try {
                            synchronized (this) {
                                wait();
                            }
                        } catch (InterruptedException e2) {
                            sb.append(e2.getMessage());
                        }
                        if (FileUtils.isExists(str2) && TextUtils.isEmpty(sb.toString())) {
                            w89.j("FFmpegChain", "concatAudio 生成成功");
                            l59 l59Var2 = new l59(new AudioPlayData(str2, 0, -1, 1.0f));
                            p59Var.a().clear();
                            p59Var.a().add(l59Var2);
                        } else {
                            g(sb.toString());
                        }
                    }
                }
            }
        }
    }

    public final void C(n59 n59Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, n59Var) == null) {
            if (n59Var == null || b99.b(n59Var.c()) < 2) {
                str = "mixAudio tempDataForOutPut data error";
            } else {
                List<p59> c2 = n59Var.c();
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                for (p59 p59Var : c2) {
                    if (p59Var != null && !b99.e(p59Var.a())) {
                        l59 l59Var = p59Var.a().get(0);
                        if (l59Var.b() != null) {
                            arrayList.add(l59Var.b().audioPath);
                        }
                    }
                }
                if (arrayList.size() >= 2) {
                    String str2 = this.g;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = FileUtils.getParentDir((String) arrayList.get(0));
                    }
                    String str3 = str2 + System.currentTimeMillis() + "_mix.aac";
                    l79.k(arrayList, str3, -1, new e(this, sb));
                    try {
                        synchronized (this) {
                            wait();
                        }
                    } catch (InterruptedException e2) {
                        sb.append(e2.getMessage());
                    }
                    if (!FileUtils.isExists(str3) || !TextUtils.isEmpty(sb.toString())) {
                        g(sb.toString());
                        return;
                    }
                    w89.j("FFmpegChain", "mixAudio 生成成功");
                    l59 l59Var2 = new l59(new AudioPlayData(str3, 0, -1, 1.0f));
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(l59Var2);
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(new p59(arrayList2));
                    this.r = new n59(arrayList3);
                    return;
                }
                str = "mixAudio inputList data error";
            }
            g(str);
        }
    }

    @Override // com.repackage.q59
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f = true;
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.repackage.q59
    public void d(n59 n59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, n59Var) == null) {
            if (n59Var == null || b99.e(n59Var.c())) {
                g("input data error: null or length=0");
                return;
            }
            this.m = false;
            this.n = false;
            this.p = false;
            this.q = false;
            if (!j(n59Var)) {
                l(n59Var);
                return;
            }
            String a2 = n59Var.a();
            this.g = a2;
            if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                new File(this.g).mkdir();
            }
            this.e = false;
            this.f = false;
            this.k = n59Var.b();
            x(n59Var);
            y(n59Var);
            this.i = 0;
            if (this.m && !this.f && !this.e) {
                A();
            }
            if (this.n && !this.f && !this.e) {
                this.i = 10;
                i(10);
                z(n59Var);
            }
            if (this.p && !this.f && !this.e) {
                this.i = 70;
                i(70);
                B(this.r);
            }
            if (this.q && !this.f && !this.e) {
                this.i = 80;
                i(80);
                C(this.r);
            }
            if (this.e || this.f) {
                return;
            }
            l(this.r);
        }
    }

    @Override // com.repackage.q59
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final void q(l59 l59Var, int i) {
        int i2;
        l59 l59Var2;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, l59Var, i) == null) || this.e || this.f) {
            return;
        }
        AudioPlayData b2 = l59Var.b();
        if (b2 == null) {
            sb = new StringBuilder();
            str = "dealAudioPlayData audioPlayData = null,trackIndx:";
        } else if (this.o != null) {
            if (!l59Var.c() && (l59Var2 = this.k) != null && l59Var2.b() != null) {
                b2.audioPath = this.k.b().audioPath;
                l59Var.d(this.k.a());
            }
            StringBuilder sb2 = new StringBuilder();
            String str2 = b2.audioPath;
            String a2 = a(str2, System.currentTimeMillis() + "_ffmpeg.aac");
            try {
                boolean z = l59Var.a() != null && "audio/mp4a-latm".equals(l59Var.a().f());
                String str3 = b2.audioPath;
                int g = this.o.g();
                int d2 = this.o.d();
                float f = b2.volume;
                int c2 = this.o.c();
                float f2 = (b2.start * 1.0f) / 1000.0f;
                float f3 = ((b2.end - b2.start) * 1.0f) / 1000.0f;
                i2 = 0;
                try {
                    l79.l(str3, a2, g, d2, f, c2, f2, f3, !z, new c(this, sb2, l59Var));
                    try {
                        synchronized (this) {
                            wait();
                        }
                    } catch (InterruptedException e2) {
                        sb2.append(e2.getMessage());
                    }
                } catch (Throwable th) {
                    th = th;
                    sb2.append(th.getMessage());
                    if (FileUtils.isExists(a2)) {
                    }
                    g(sb2.toString());
                    return;
                }
            } catch (Throwable th2) {
                th = th2;
                i2 = 0;
            }
            if (FileUtils.isExists(a2) || !TextUtils.isEmpty(sb2.toString())) {
                g(sb2.toString());
                return;
            }
            w89.j("FFmpegChain", "dealAudioPlayData 生成成功");
            r(this.r, new l59(new AudioPlayData(a2, i2, -1, 1.0f)), i);
            return;
        } else {
            sb = new StringBuilder();
            str = "dealAudioPlayData mTargetInfo = null ,trackIndx:";
        }
        sb.append(str);
        sb.append(i);
        g(sb.toString());
    }

    public final void r(n59 n59Var, l59 l59Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048583, this, n59Var, l59Var, i) == null) || n59Var == null || n59Var.c() == null || n59Var.c().get(i) == null) {
            return;
        }
        n59Var.c().get(i).a().add(l59Var);
    }

    public final void s(p59 p59Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, p59Var, i) == null) || p59Var == null || b99.e(p59Var.a()) || this.f || this.e) {
            return;
        }
        for (int i2 = 0; !this.e && !this.f && i2 < p59Var.a().size(); i2++) {
            l59 l59Var = p59Var.a().get(i2);
            this.j++;
            if (v(l59Var)) {
                q(l59Var, i);
            } else {
                r(this.r, l59Var, i);
                i(this.i + ((int) (((this.j * 1.0f) / this.h) * 60.0f)));
            }
        }
    }

    public final boolean t(l59 l59Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, l59Var)) == null) {
            if (l59Var == null || l59Var.b() == null || !FileUtils.isExists(l59Var.b().audioPath)) {
                return false;
            }
            if (l59Var.b().start <= 0 && l59Var.b().end <= 0 && l59Var.b().volume == 1.0f) {
                return (l59Var.a() == null || "audio/mp4a-latm".equals(l59Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean v(l59 l59Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, l59Var)) == null) {
            if (l59Var == null) {
                return false;
            }
            return t(l59Var) || l59Var.a() == null || l59Var.a().k(this.o) != 0;
        }
        return invokeL.booleanValue;
    }

    public final void x(n59 n59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, n59Var) == null) {
            List<p59> c2 = n59Var.c();
            HashMap hashMap = new HashMap();
            if (c2.size() > 1) {
                this.q = true;
            }
            int i = 0;
            for (int i2 = 0; i2 < c2.size(); i2++) {
                if (!b99.e(c2.get(i2).a())) {
                    this.h += b99.b(c2.get(i2).a());
                    List<l59> a2 = c2.get(i2).a();
                    if (!b99.e(a2)) {
                        if (a2.size() > 1) {
                            this.p = true;
                        }
                        for (l59 l59Var : a2) {
                            if (l59Var != null && l59Var.b() != null && !l59Var.c()) {
                                long j = l59Var.b().end - l59Var.b().start;
                                if (j > this.l) {
                                    this.l = j;
                                }
                                this.m = true;
                                this.n = true;
                            }
                            if (t(l59Var)) {
                                this.n = true;
                            }
                            if (l59Var != null && l59Var.a() != null) {
                                Integer num = (Integer) hashMap.get(l59Var.a());
                                if (num == null) {
                                    num = 0;
                                }
                                hashMap.put(l59Var.a(), Integer.valueOf(num.intValue() + 1));
                            }
                        }
                    }
                }
            }
            if (hashMap.size() > 1) {
                this.n = true;
            }
            for (m59 m59Var : hashMap.keySet()) {
                if (((Integer) hashMap.get(m59Var)).intValue() > i && "audio/mp4a-latm".equals(m59Var.f())) {
                    this.o = m59Var;
                    i = ((Integer) hashMap.get(m59Var)).intValue();
                }
            }
            if (this.o == null) {
                this.o = m59.b();
            }
        }
    }

    public final void y(n59 n59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, n59Var) == null) {
            if (this.n) {
                if (n59Var == null || b99.e(n59Var.c())) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < n59Var.c().size(); i++) {
                    arrayList.add(new p59(new ArrayList()));
                }
                n59Var = new n59(arrayList);
            }
            this.r = n59Var;
        }
    }

    public final void z(n59 n59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, n59Var) == null) {
            List<p59> c2 = n59Var.c();
            int size = c2.size();
            for (int i = 0; i < size; i++) {
                s(c2.get(i), i);
            }
        }
    }
}
