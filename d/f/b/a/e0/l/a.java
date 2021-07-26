package d.f.b.a.e0.l;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.facebook.imageutils.JfifUtil;
import d.f.b.a.e0.h;
import d.f.b.a.i0.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes8.dex */
public final class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] r;
    public static final int[] s;
    public static final int[] t;
    public static final int[] u;
    public static final int[] v;
    public static final int[] w;
    public static final int[] x;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final l f70595f;

    /* renamed from: g  reason: collision with root package name */
    public final int f70596g;

    /* renamed from: h  reason: collision with root package name */
    public final int f70597h;

    /* renamed from: i  reason: collision with root package name */
    public final LinkedList<C1982a> f70598i;
    public C1982a j;
    public List<d.f.b.a.e0.b> k;
    public List<d.f.b.a.e0.b> l;
    public int m;
    public int n;
    public boolean o;
    public byte p;
    public byte q;

    /* renamed from: d.f.b.a.e0.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1982a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<CharacterStyle> f70599a;

        /* renamed from: b  reason: collision with root package name */
        public final List<C1983a> f70600b;

        /* renamed from: c  reason: collision with root package name */
        public final List<SpannableString> f70601c;

        /* renamed from: d  reason: collision with root package name */
        public final SpannableStringBuilder f70602d;

        /* renamed from: e  reason: collision with root package name */
        public int f70603e;

        /* renamed from: f  reason: collision with root package name */
        public int f70604f;

        /* renamed from: g  reason: collision with root package name */
        public int f70605g;

        /* renamed from: h  reason: collision with root package name */
        public int f70606h;

        /* renamed from: i  reason: collision with root package name */
        public int f70607i;
        public int j;

        /* renamed from: d.f.b.a.e0.l.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C1983a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final CharacterStyle f70608a;

            /* renamed from: b  reason: collision with root package name */
            public final int f70609b;

            /* renamed from: c  reason: collision with root package name */
            public final int f70610c;

            public C1983a(CharacterStyle characterStyle, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {characterStyle, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70608a = characterStyle;
                this.f70609b = i2;
                this.f70610c = i3;
            }
        }

        public C1982a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70599a = new ArrayList();
            this.f70600b = new ArrayList();
            this.f70601c = new LinkedList();
            this.f70602d = new SpannableStringBuilder();
            g(i2, i3);
        }

        public void a(char c2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Character.valueOf(c2)}) == null) {
                this.f70602d.append(c2);
            }
        }

        public void b() {
            int length;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (length = this.f70602d.length()) <= 0) {
                return;
            }
            this.f70602d.delete(length - 1, length);
        }

        public d.f.b.a.e0.b c() {
            InterceptResult invokeV;
            int length;
            float f2;
            int i2;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                for (int i5 = 0; i5 < this.f70601c.size(); i5++) {
                    spannableStringBuilder.append((CharSequence) this.f70601c.get(i5));
                    spannableStringBuilder.append('\n');
                }
                spannableStringBuilder.append((CharSequence) d());
                if (spannableStringBuilder.length() == 0) {
                    return null;
                }
                int i6 = this.f70604f + this.f70605g;
                int length2 = i6 - ((32 - i6) - spannableStringBuilder.length());
                if (this.f70606h == 2 && Math.abs(length2) < 3) {
                    f2 = 0.5f;
                    i2 = 1;
                } else if (this.f70606h != 2 || length2 <= 0) {
                    f2 = ((i6 / 32.0f) * 0.8f) + 0.1f;
                    i2 = 0;
                } else {
                    f2 = (((32 - length) / 32.0f) * 0.8f) + 0.1f;
                    i2 = 2;
                }
                if (this.f70606h == 1 || (i3 = this.f70603e) > 7) {
                    i3 = (this.f70603e - 15) - 2;
                    i4 = 2;
                } else {
                    i4 = 0;
                }
                return new d.f.b.a.e0.b(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i3, 1, i4, f2, i2, Float.MIN_VALUE);
            }
            return (d.f.b.a.e0.b) invokeV.objValue;
        }

        public SpannableString d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int length = this.f70602d.length();
                int i2 = 0;
                for (int i3 = 0; i3 < this.f70599a.size(); i3++) {
                    this.f70602d.setSpan(this.f70599a.get(i3), 0, length, 33);
                }
                while (i2 < this.f70600b.size()) {
                    C1983a c1983a = this.f70600b.get(i2);
                    int size = this.f70600b.size();
                    int i4 = c1983a.f70610c;
                    this.f70602d.setSpan(c1983a.f70608a, c1983a.f70609b, i2 < size - i4 ? this.f70600b.get(i4 + i2).f70609b : length, 33);
                    i2++;
                }
                if (this.j != -1) {
                    this.f70602d.setSpan(new UnderlineSpan(), this.j, length, 33);
                }
                return new SpannableString(this.f70602d);
            }
            return (SpannableString) invokeV.objValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f70603e : invokeV.intValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f70599a.isEmpty() && this.f70600b.isEmpty() && this.f70601c.isEmpty() && this.f70602d.length() == 0 : invokeV.booleanValue;
        }

        public void g(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
                this.f70599a.clear();
                this.f70600b.clear();
                this.f70601c.clear();
                this.f70602d.clear();
                this.f70603e = 15;
                this.f70604f = 0;
                this.f70605g = 0;
                this.f70606h = i2;
                this.f70607i = i3;
                this.j = -1;
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f70601c.add(d());
                this.f70602d.clear();
                this.f70599a.clear();
                this.f70600b.clear();
                this.j = -1;
                int min = Math.min(this.f70607i, this.f70603e);
                while (this.f70601c.size() >= min) {
                    this.f70601c.remove(0);
                }
            }
        }

        public void i(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                this.f70604f = i2;
            }
        }

        public void j(CharacterStyle characterStyle, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048585, this, characterStyle, i2) == null) {
                this.f70600b.add(new C1983a(characterStyle, this.f70602d.length(), i2));
            }
        }

        public void k(CharacterStyle characterStyle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, characterStyle) == null) {
                this.f70599a.add(characterStyle);
            }
        }

        public void l(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
                this.f70603e = i2;
            }
        }

        public void m(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
                this.f70605g = i2;
            }
        }

        public void n(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
                if (z) {
                    this.j = this.f70602d.length();
                } else if (this.j != -1) {
                    this.f70602d.setSpan(new UnderlineSpan(), this.j, this.f70602d.length(), 33);
                    this.j = -1;
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f70602d.toString() : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1197537830, "Ld/f/b/a/e0/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1197537830, "Ld/f/b/a/e0/l/a;");
                return;
            }
        }
        r = new int[]{11, 1, 3, 12, 14, 5, 7, 9};
        s = new int[]{0, 4, 8, 12, 16, 20, 24, 28};
        t = new int[]{-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, -256, -65281};
        u = new int[]{32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, WriteActivity.CONTENT_MAX_COUNT, 93, 237, LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, GDiffPatcher.DATA_USHORT, 209, BaseActivity.DIALOG_PROMPT, 9632};
        v = new int[]{174, Opcodes.ARETURN, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, Constants.METHOD_MEDIA_NOTIFY, 234, 238, 244, GDiffPatcher.COPY_USHORT_INT};
        w = new int[]{193, 201, 211, 218, PassLivenessRecogActivity.S, GDiffPatcher.COPY_INT_UBYTE, 8216, 161, 42, 39, 8212, Opcodes.RET, 8480, 8226, 8220, 8221, 192, 194, Opcodes.IFNONNULL, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, Opcodes.NEW};
        x = new int[]{DownloadConstants.STATUS_WAITING_FOR_NETWORK, 227, 205, 204, 236, 210, BaseActivity.DIALOG_LOADING, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, IChannelPay.ID_IPAY_PAY_GAME, 9474, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 229, JfifUtil.MARKER_SOI, GDiffPatcher.DATA_INT, 9484, 9488, 9492, 9496};
    }

    public a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70595f = new l();
        this.f70598i = new LinkedList<>();
        this.j = new C1982a(0, 4);
        this.f70596g = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i2 != 3 && i2 != 4) {
            this.f70597h = 1;
        } else {
            this.f70597h = 2;
        }
        B(0);
        A();
    }

    public static char m(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b2)) == null) ? (char) u[(b2 & ByteCompanionObject.MAX_VALUE) - 32] : invokeB.charValue;
    }

    public static char o(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(65539, null, b2)) == null) ? (char) w[b2 & 31] : invokeB.charValue;
    }

    public static char p(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(InputDeviceCompat.SOURCE_TRACKBALL, null, b2)) == null) ? (char) x[b2 & 31] : invokeB.charValue;
    }

    public static char q(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(AdIconUtil.AD_TEXT_ID, null, b2)) == null) ? (char) v[b2 & 15] : invokeB.charValue;
    }

    public static boolean v(byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)})) == null) ? (b2 & 247) == 17 && (b3 & 240) == 32 : invokeCommon.booleanValue;
    }

    public static boolean w(byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)})) == null) ? (b2 & 247) == 20 && (b3 & 240) == 32 : invokeCommon.booleanValue;
    }

    public static boolean x(byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)})) == null) ? (b2 & 240) == 16 && (b3 & 192) == 64 : invokeCommon.booleanValue;
    }

    public static boolean y(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(65545, null, b2)) == null) ? (b2 & 240) == 16 : invokeB.booleanValue;
    }

    public static boolean z(byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)})) == null) ? (b2 & 247) == 23 && b3 >= 33 && b3 <= 35 : invokeCommon.booleanValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j.g(this.m, this.n);
            this.f70598i.clear();
            this.f70598i.add(this.j);
        }
    }

    public final void B(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (i3 = this.m) == i2) {
            return;
        }
        this.m = i2;
        A();
        if (i3 == 3 || i2 == 1 || i2 == 0) {
            this.k = null;
        }
    }

    @Override // d.f.b.a.e0.l.d
    public d.f.b.a.e0.e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<d.f.b.a.e0.b> list = this.k;
            this.l = list;
            return new f(list);
        }
        return (d.f.b.a.e0.e) invokeV.objValue;
    }

    @Override // d.f.b.a.e0.l.d
    public void f(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) {
            this.f70595f.H(hVar.f71209g.array(), hVar.f71209g.limit());
            boolean z = false;
            boolean z2 = false;
            while (true) {
                int a2 = this.f70595f.a();
                int i2 = this.f70596g;
                if (a2 < i2) {
                    break;
                }
                byte x2 = i2 == 2 ? (byte) -4 : (byte) this.f70595f.x();
                byte x3 = (byte) (this.f70595f.x() & 127);
                byte x4 = (byte) (this.f70595f.x() & 127);
                if ((x2 & 6) == 4 && (this.f70597h != 1 || (x2 & 1) == 0)) {
                    if (this.f70597h != 2 || (x2 & 1) == 1) {
                        if (x3 != 0 || x4 != 0) {
                            if ((x3 & 247) == 17 && (x4 & 240) == 48) {
                                this.j.a(q(x4));
                            } else if ((x3 & 246) == 18 && (x4 & 224) == 32) {
                                this.j.b();
                                if ((x3 & 1) == 0) {
                                    this.j.a(o(x4));
                                } else {
                                    this.j.a(p(x4));
                                }
                            } else if ((x3 & 224) == 0) {
                                z2 = r(x3, x4);
                            } else {
                                this.j.a(m(x3));
                                if ((x4 & 224) != 0) {
                                    this.j.a(m(x4));
                                }
                            }
                            z = true;
                        }
                    }
                }
            }
            if (z) {
                if (!z2) {
                    this.o = false;
                }
                int i3 = this.m;
                if (i3 == 1 || i3 == 3) {
                    this.k = n();
                }
            }
        }
    }

    @Override // d.f.b.a.e0.l.d, d.f.b.a.y.c
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.flush();
            this.k = null;
            this.l = null;
            B(0);
            A();
            this.n = 4;
            this.o = false;
            this.p = (byte) 0;
            this.q = (byte) 0;
        }
    }

    @Override // d.f.b.a.e0.l.d
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k != this.l : invokeV.booleanValue;
    }

    public final List<d.f.b.a.e0.b> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f70598i.size(); i2++) {
                d.f.b.a.e0.b c2 = this.f70598i.get(i2).c();
                if (c2 != null) {
                    arrayList.add(c2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean r(byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)})) == null) {
            boolean y = y(b2);
            if (y) {
                if (this.o && this.p == b2 && this.q == b3) {
                    this.o = false;
                    return true;
                }
                this.o = true;
                this.p = b2;
                this.q = b3;
            }
            if (v(b2, b3)) {
                s(b3);
            } else if (x(b2, b3)) {
                u(b2, b3);
            } else if (z(b2, b3)) {
                this.j.m(b3 - 32);
            } else if (w(b2, b3)) {
                t(b3);
            }
            return y;
        }
        return invokeCommon.booleanValue;
    }

    @Override // d.f.b.a.e0.l.d, d.f.b.a.y.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final void s(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048585, this, b2) == null) {
            this.j.n((b2 & 1) == 1);
            int i2 = (b2 >> 1) & 15;
            if (i2 == 7) {
                this.j.j(new StyleSpan(2), 2);
                this.j.j(new ForegroundColorSpan(-1), 1);
                return;
            }
            this.j.j(new ForegroundColorSpan(t[i2]), 1);
        }
    }

    public final void t(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048586, this, b2) == null) {
            if (b2 == 32) {
                B(2);
            } else if (b2 != 41) {
                switch (b2) {
                    case 37:
                        this.n = 2;
                        B(1);
                        return;
                    case 38:
                        this.n = 3;
                        B(1);
                        return;
                    case 39:
                        this.n = 4;
                        B(1);
                        return;
                    default:
                        int i2 = this.m;
                        if (i2 == 0) {
                            return;
                        }
                        if (b2 != 33) {
                            switch (b2) {
                                case 44:
                                    this.k = null;
                                    if (i2 == 1 || i2 == 3) {
                                        A();
                                        return;
                                    }
                                    return;
                                case 45:
                                    if (i2 != 1 || this.j.f()) {
                                        return;
                                    }
                                    this.j.h();
                                    return;
                                case 46:
                                    A();
                                    return;
                                case 47:
                                    this.k = n();
                                    A();
                                    return;
                                default:
                                    return;
                            }
                        }
                        this.j.b();
                        return;
                }
            } else {
                B(3);
            }
        }
    }

    public final void u(byte b2, byte b3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)}) == null) {
            int i2 = r[b2 & 7];
            if ((b3 & 32) != 0) {
                i2++;
            }
            if (i2 != this.j.e()) {
                if (this.m != 1 && !this.j.f()) {
                    C1982a c1982a = new C1982a(this.m, this.n);
                    this.j = c1982a;
                    this.f70598i.add(c1982a);
                }
                this.j.l(i2);
            }
            if ((b3 & 1) == 1) {
                this.j.k(new UnderlineSpan());
            }
            int i3 = (b3 >> 1) & 15;
            if (i3 > 7) {
                this.j.i(s[i3 & 7]);
            } else if (i3 == 7) {
                this.j.k(new StyleSpan(2));
                this.j.k(new ForegroundColorSpan(-1));
            } else {
                this.j.k(new ForegroundColorSpan(t[i3]));
            }
        }
    }
}
