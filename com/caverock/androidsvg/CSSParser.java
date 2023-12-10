package com.caverock.androidsvg;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.utils.enums.ShareDirectionType;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.security.WarmTipsManager;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.g0c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes9.dex */
public class CSSParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaType a;
    public Source b;
    public boolean c;

    /* loaded from: classes9.dex */
    public interface d {
        boolean a(m mVar, SVG.j0 j0Var);
    }

    /* loaded from: classes9.dex */
    public static class c extends SVGParser.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public final int C(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (i < 48 || i > 57) {
                    int i2 = 65;
                    if (i < 65 || i > 70) {
                        i2 = 97;
                        if (i < 97 || i > 102) {
                            return -1;
                        }
                    }
                    return (i - i2) + 10;
                }
                return i - 48;
            }
            return invokeI.intValue;
        }

        /* loaded from: classes9.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public int b;

            public a(int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = i;
                this.b = i2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public final a D() throws CSSParseException {
            InterceptResult invokeV;
            int i;
            g0c g0cVar;
            int d;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (h()) {
                    return null;
                }
                int i2 = this.b;
                if (!f('(')) {
                    return null;
                }
                A();
                int i3 = 1;
                if (g("odd")) {
                    aVar = new a(2, 1);
                } else {
                    int i4 = 0;
                    if (g("even")) {
                        aVar = new a(2, 0);
                    } else {
                        if (!f('+') && f(SignatureImpl.SEP)) {
                            i = -1;
                        } else {
                            i = 1;
                        }
                        g0c c = g0c.c(this.a, this.b, this.c, false);
                        if (c != null) {
                            this.b = c.a();
                        }
                        if (!f('n') && !f('N')) {
                            g0cVar = c;
                            c = null;
                        } else {
                            if (c == null) {
                                c = new g0c(1L, this.b);
                            }
                            A();
                            boolean f = f('+');
                            if (!f && (f = f(SignatureImpl.SEP))) {
                                i3 = -1;
                            }
                            if (f) {
                                A();
                                g0cVar = g0c.c(this.a, this.b, this.c, false);
                                if (g0cVar != null) {
                                    this.b = g0cVar.a();
                                } else {
                                    this.b = i2;
                                    return null;
                                }
                            } else {
                                g0cVar = null;
                            }
                            int i5 = i3;
                            i3 = i;
                            i = i5;
                        }
                        if (c == null) {
                            d = 0;
                        } else {
                            d = i3 * c.d();
                        }
                        if (g0cVar != null) {
                            i4 = i * g0cVar.d();
                        }
                        aVar = new a(d, i4);
                    }
                }
                A();
                if (f(')')) {
                    return aVar;
                }
                this.b = i2;
                return null;
            }
            return (a) invokeV.objValue;
        }

        public final String E() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (h()) {
                    return null;
                }
                String q = q();
                if (q != null) {
                    return q;
                }
                return H();
            }
            return (String) invokeV.objValue;
        }

        public String H() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int P = P();
                int i = this.b;
                if (P == i) {
                    return null;
                }
                String substring = this.a.substring(i, P);
                this.b = P;
                return substring;
            }
            return (String) invokeV.objValue;
        }

        public String F() {
            InterceptResult invokeV;
            int C;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (h()) {
                    return null;
                }
                char charAt = this.a.charAt(this.b);
                if (charAt != '\'' && charAt != '\"') {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                this.b++;
                int intValue = l().intValue();
                while (intValue != -1 && intValue != charAt) {
                    if (intValue == 92) {
                        intValue = l().intValue();
                        if (intValue != -1) {
                            if (intValue != 10 && intValue != 13 && intValue != 12) {
                                int C2 = C(intValue);
                                if (C2 != -1) {
                                    for (int i = 1; i <= 5 && (C = C((intValue = l().intValue()))) != -1; i++) {
                                        C2 = (C2 * 16) + C;
                                    }
                                    sb.append((char) C2);
                                }
                            } else {
                                intValue = l().intValue();
                            }
                        }
                    }
                    sb.append((char) intValue);
                    intValue = l().intValue();
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public String I() {
            InterceptResult invokeV;
            char charAt;
            int C;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                StringBuilder sb = new StringBuilder();
                while (!h() && (charAt = this.a.charAt(this.b)) != '\'' && charAt != '\"' && charAt != '(' && charAt != ')' && !k(charAt) && !Character.isISOControl((int) charAt)) {
                    this.b++;
                    if (charAt == '\\') {
                        if (!h()) {
                            String str = this.a;
                            int i = this.b;
                            this.b = i + 1;
                            charAt = str.charAt(i);
                            if (charAt != '\n' && charAt != '\r' && charAt != '\f') {
                                int C2 = C(charAt);
                                if (C2 != -1) {
                                    for (int i2 = 1; i2 <= 5 && !h() && (C = C(this.a.charAt(this.b))) != -1; i2++) {
                                        this.b++;
                                        C2 = (C2 * 16) + C;
                                    }
                                    sb.append((char) C2);
                                }
                            }
                        }
                    }
                    sb.append(charAt);
                }
                if (sb.length() == 0) {
                    return null;
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public final List<String> G() throws CSSParseException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (h()) {
                    return null;
                }
                int i = this.b;
                if (!f('(')) {
                    return null;
                }
                A();
                ArrayList arrayList = null;
                do {
                    String H = H();
                    if (H == null) {
                        this.b = i;
                        return null;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(H);
                    A();
                } while (z());
                if (f(')')) {
                    return arrayList;
                }
                this.b = i;
                return null;
            }
            return (List) invokeV.objValue;
        }

        public String J() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (h()) {
                    return null;
                }
                int i = this.b;
                int charAt = this.a.charAt(i);
                int i2 = i;
                while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !j(charAt)) {
                    if (!k(charAt)) {
                        i2 = this.b + 1;
                    }
                    charAt = a();
                }
                if (this.b > i) {
                    return this.a.substring(i, i2);
                }
                this.b = i;
                return null;
            }
            return (String) invokeV.objValue;
        }

        public final List<o> L() throws CSSParseException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                if (h()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(1);
                o oVar = new o(null);
                while (!h() && M(oVar)) {
                    if (z()) {
                        arrayList.add(oVar);
                        oVar = new o(null);
                    }
                }
                if (!oVar.f()) {
                    arrayList.add(oVar);
                }
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public String N() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (h()) {
                    return null;
                }
                int i = this.b;
                if (!g("url(")) {
                    return null;
                }
                A();
                String F = F();
                if (F == null) {
                    F = I();
                }
                if (F == null) {
                    this.b = i;
                    return null;
                }
                A();
                if (!h() && !g(SmallTailInfo.EMOTION_SUFFIX)) {
                    this.b = i;
                    return null;
                }
                return F;
            }
            return (String) invokeV.objValue;
        }

        public final int P() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                if (h()) {
                    return this.b;
                }
                int i2 = this.b;
                int charAt = this.a.charAt(i2);
                if (charAt == 45) {
                    charAt = a();
                }
                if ((charAt >= 65 && charAt <= 90) || ((charAt >= 97 && charAt <= 122) || charAt == 95)) {
                    int a2 = a();
                    while (true) {
                        if ((a2 < 65 || a2 > 90) && ((a2 < 97 || a2 > 122) && !((a2 >= 48 && a2 <= 57) || a2 == 45 || a2 == 95))) {
                            break;
                        }
                        a2 = a();
                    }
                    i = this.b;
                } else {
                    i = i2;
                }
                this.b = i2;
                return i;
            }
            return invokeV.intValue;
        }

        public final List<o> K() throws CSSParseException {
            InterceptResult invokeV;
            List<p> list;
            List<d> list2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (h()) {
                    return null;
                }
                int i = this.b;
                if (!f('(')) {
                    return null;
                }
                A();
                List<o> L = L();
                if (L == null) {
                    this.b = i;
                    return null;
                } else if (!f(')')) {
                    this.b = i;
                    return null;
                } else {
                    Iterator<o> it = L.iterator();
                    while (it.hasNext() && (list = it.next().a) != null) {
                        Iterator<p> it2 = list.iterator();
                        while (it2.hasNext() && (list2 = it2.next().d) != null) {
                            for (d dVar : list2) {
                                if (dVar instanceof g) {
                                    return null;
                                }
                            }
                        }
                    }
                    return L;
                }
            }
            return (List) invokeV.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0134  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0139  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean M(o oVar) throws CSSParseException {
            InterceptResult invokeL;
            Combinator combinator;
            p pVar;
            AttribOp attribOp;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, oVar)) == null) {
                if (h()) {
                    return false;
                }
                int i = this.b;
                if (!oVar.f()) {
                    if (f('>')) {
                        combinator = Combinator.CHILD;
                        A();
                    } else if (f('+')) {
                        combinator = Combinator.FOLLOWS;
                        A();
                    }
                    if (!f('*')) {
                        pVar = new p(combinator, null);
                    } else {
                        String H = H();
                        if (H != null) {
                            p pVar2 = new p(combinator, H);
                            oVar.c();
                            pVar = pVar2;
                        } else {
                            pVar = null;
                        }
                    }
                    while (!h()) {
                        if (f(IStringUtil.EXTENSION_SEPARATOR)) {
                            if (pVar == null) {
                                pVar = new p(combinator, null);
                            }
                            String H2 = H();
                            if (H2 != null) {
                                pVar.a("class", AttribOp.EQUALS, H2);
                                oVar.b();
                            } else {
                                throw new CSSParseException("Invalid \".class\" simpleSelectors");
                            }
                        } else if (f('#')) {
                            if (pVar == null) {
                                pVar = new p(combinator, null);
                            }
                            String H3 = H();
                            if (H3 != null) {
                                pVar.a("id", AttribOp.EQUALS, H3);
                                oVar.d();
                            } else {
                                throw new CSSParseException("Invalid \"#id\" simpleSelectors");
                            }
                        } else if (f('[')) {
                            if (pVar == null) {
                                pVar = new p(combinator, null);
                            }
                            A();
                            String H4 = H();
                            if (H4 != null) {
                                A();
                                if (f('=')) {
                                    attribOp = AttribOp.EQUALS;
                                } else if (g("~=")) {
                                    attribOp = AttribOp.INCLUDES;
                                } else if (g("|=")) {
                                    attribOp = AttribOp.DASHMATCH;
                                } else {
                                    attribOp = null;
                                }
                                if (attribOp != null) {
                                    A();
                                    str = E();
                                    if (str != null) {
                                        A();
                                    } else {
                                        throw new CSSParseException("Invalid attribute simpleSelectors");
                                    }
                                } else {
                                    str = null;
                                }
                                if (f(']')) {
                                    if (attribOp == null) {
                                        attribOp = AttribOp.EXISTS;
                                    }
                                    pVar.a(H4, attribOp, str);
                                    oVar.b();
                                } else {
                                    throw new CSSParseException("Invalid attribute simpleSelectors");
                                }
                            } else {
                                throw new CSSParseException("Invalid attribute simpleSelectors");
                            }
                        } else if (!f(':')) {
                            break;
                        } else {
                            if (pVar == null) {
                                pVar = new p(combinator, null);
                            }
                            O(oVar, pVar);
                        }
                    }
                    if (pVar == null) {
                        oVar.a(pVar);
                        return true;
                    }
                    this.b = i;
                    return false;
                }
                combinator = null;
                if (!f('*')) {
                }
                while (!h()) {
                }
                if (pVar == null) {
                }
            } else {
                return invokeL.booleanValue;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.caverock.androidsvg.CSSParser$g */
        /* JADX WARN: Multi-variable type inference failed */
        public final void O(o oVar, p pVar) throws CSSParseException {
            d eVar;
            boolean z;
            boolean z2;
            e eVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, oVar, pVar) == null) {
                String H = H();
                if (H != null) {
                    PseudoClassIdents fromString = PseudoClassIdents.fromString(H);
                    switch (a.b[fromString.ordinal()]) {
                        case 1:
                            eVar = new e(0, 1, true, false, null);
                            oVar.b();
                            break;
                        case 2:
                            eVar = new e(0, 1, false, false, null);
                            oVar.b();
                            break;
                        case 3:
                            eVar = new i(false, null);
                            oVar.b();
                            break;
                        case 4:
                            eVar = new e(0, 1, true, true, pVar.b);
                            oVar.b();
                            break;
                        case 5:
                            eVar = new e(0, 1, false, true, pVar.b);
                            oVar.b();
                            break;
                        case 6:
                            eVar = new i(true, pVar.b);
                            oVar.b();
                            break;
                        case 7:
                            eVar = new j(null);
                            oVar.b();
                            break;
                        case 8:
                            eVar = new f(null);
                            oVar.b();
                            break;
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                            if (fromString != PseudoClassIdents.nth_child && fromString != PseudoClassIdents.nth_of_type) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (fromString != PseudoClassIdents.nth_of_type && fromString != PseudoClassIdents.nth_last_of_type) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            a D = D();
                            if (D != null) {
                                e eVar3 = new e(D.a, D.b, z, z2, pVar.b);
                                oVar.b();
                                eVar2 = eVar3;
                                eVar = eVar2;
                                break;
                            } else {
                                throw new CSSParseException("Invalid or missing parameter section for pseudo class: " + H);
                            }
                            break;
                        case 13:
                            List<o> K = K();
                            if (K != null) {
                                g gVar = new g(K);
                                oVar.b = gVar.b();
                                eVar2 = gVar;
                                eVar = eVar2;
                                break;
                            } else {
                                throw new CSSParseException("Invalid or missing parameter section for pseudo class: " + H);
                            }
                        case 14:
                            eVar = new k(null);
                            oVar.b();
                            break;
                        case 15:
                            G();
                            eVar = new h(H);
                            oVar.b();
                            break;
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                            eVar = new h(H);
                            oVar.b();
                            break;
                        default:
                            throw new CSSParseException("Unsupported pseudo class: " + H);
                    }
                    pVar.b(eVar);
                    return;
                }
                throw new CSSParseException("Invalid pseudo class");
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class AttribOp {
        public static final /* synthetic */ AttribOp[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AttribOp DASHMATCH;
        public static final AttribOp EQUALS;
        public static final AttribOp EXISTS;
        public static final AttribOp INCLUDES;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-53863337, "Lcom/caverock/androidsvg/CSSParser$AttribOp;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-53863337, "Lcom/caverock/androidsvg/CSSParser$AttribOp;");
                    return;
                }
            }
            EXISTS = new AttribOp("EXISTS", 0);
            EQUALS = new AttribOp("EQUALS", 1);
            INCLUDES = new AttribOp("INCLUDES", 2);
            AttribOp attribOp = new AttribOp("DASHMATCH", 3);
            DASHMATCH = attribOp;
            $VALUES = new AttribOp[]{EXISTS, EQUALS, INCLUDES, attribOp};
        }

        public AttribOp(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static AttribOp valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (AttribOp) Enum.valueOf(AttribOp.class, str);
            }
            return (AttribOp) invokeL.objValue;
        }

        public static AttribOp[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (AttribOp[]) $VALUES.clone();
            }
            return (AttribOp[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class Combinator {
        public static final /* synthetic */ Combinator[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Combinator CHILD;
        public static final Combinator DESCENDANT;
        public static final Combinator FOLLOWS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-526963514, "Lcom/caverock/androidsvg/CSSParser$Combinator;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-526963514, "Lcom/caverock/androidsvg/CSSParser$Combinator;");
                    return;
                }
            }
            DESCENDANT = new Combinator("DESCENDANT", 0);
            CHILD = new Combinator("CHILD", 1);
            Combinator combinator = new Combinator("FOLLOWS", 2);
            FOLLOWS = combinator;
            $VALUES = new Combinator[]{DESCENDANT, CHILD, combinator};
        }

        public Combinator(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Combinator valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Combinator) Enum.valueOf(Combinator.class, str);
            }
            return (Combinator) invokeL.objValue;
        }

        public static Combinator[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Combinator[]) $VALUES.clone();
            }
            return (Combinator[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class MediaType {
        public static final /* synthetic */ MediaType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MediaType all;
        public static final MediaType aural;
        public static final MediaType braille;
        public static final MediaType embossed;
        public static final MediaType handheld;
        public static final MediaType print;
        public static final MediaType projection;
        public static final MediaType screen;
        public static final MediaType speech;
        public static final MediaType tty;

        /* renamed from: tv  reason: collision with root package name */
        public static final MediaType f1190tv;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-144415082, "Lcom/caverock/androidsvg/CSSParser$MediaType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-144415082, "Lcom/caverock/androidsvg/CSSParser$MediaType;");
                    return;
                }
            }
            all = new MediaType("all", 0);
            aural = new MediaType("aural", 1);
            braille = new MediaType("braille", 2);
            embossed = new MediaType("embossed", 3);
            handheld = new MediaType("handheld", 4);
            print = new MediaType("print", 5);
            projection = new MediaType("projection", 6);
            screen = new MediaType("screen", 7);
            speech = new MediaType(WarmTipsManager.WIDGET_SPEECH_EXT_VALUE, 8);
            tty = new MediaType("tty", 9);
            MediaType mediaType = new MediaType(Config.TARGET_SDK_VERSION, 10);
            f1190tv = mediaType;
            $VALUES = new MediaType[]{all, aural, braille, embossed, handheld, print, projection, screen, speech, tty, mediaType};
        }

        public MediaType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static MediaType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (MediaType) Enum.valueOf(MediaType.class, str);
            }
            return (MediaType) invokeL.objValue;
        }

        public static MediaType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (MediaType[]) $VALUES.clone();
            }
            return (MediaType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class PseudoClassIdents {
        public static final /* synthetic */ PseudoClassIdents[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PseudoClassIdents UNSUPPORTED;
        public static final PseudoClassIdents active;
        public static final Map<String, PseudoClassIdents> cache;
        public static final PseudoClassIdents checked;
        public static final PseudoClassIdents disabled;
        public static final PseudoClassIdents empty;
        public static final PseudoClassIdents enabled;
        public static final PseudoClassIdents first_child;
        public static final PseudoClassIdents first_of_type;
        public static final PseudoClassIdents focus;
        public static final PseudoClassIdents hover;
        public static final PseudoClassIdents indeterminate;
        public static final PseudoClassIdents lang;
        public static final PseudoClassIdents last_child;
        public static final PseudoClassIdents last_of_type;
        public static final PseudoClassIdents link;
        public static final PseudoClassIdents not;
        public static final PseudoClassIdents nth_child;
        public static final PseudoClassIdents nth_last_child;
        public static final PseudoClassIdents nth_last_of_type;
        public static final PseudoClassIdents nth_of_type;
        public static final PseudoClassIdents only_child;
        public static final PseudoClassIdents only_of_type;
        public static final PseudoClassIdents root;
        public static final PseudoClassIdents target;
        public static final PseudoClassIdents visited;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            PseudoClassIdents[] values;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(788114231, "Lcom/caverock/androidsvg/CSSParser$PseudoClassIdents;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(788114231, "Lcom/caverock/androidsvg/CSSParser$PseudoClassIdents;");
                    return;
                }
            }
            target = new PseudoClassIdents("target", 0);
            root = new PseudoClassIdents("root", 1);
            nth_child = new PseudoClassIdents("nth_child", 2);
            nth_last_child = new PseudoClassIdents("nth_last_child", 3);
            nth_of_type = new PseudoClassIdents("nth_of_type", 4);
            nth_last_of_type = new PseudoClassIdents("nth_last_of_type", 5);
            first_child = new PseudoClassIdents("first_child", 6);
            last_child = new PseudoClassIdents("last_child", 7);
            first_of_type = new PseudoClassIdents("first_of_type", 8);
            last_of_type = new PseudoClassIdents("last_of_type", 9);
            only_child = new PseudoClassIdents("only_child", 10);
            only_of_type = new PseudoClassIdents("only_of_type", 11);
            empty = new PseudoClassIdents(SchemeCollecter.CLASSIFY_EMPTY, 12);
            not = new PseudoClassIdents("not", 13);
            lang = new PseudoClassIdents(WebvttCueParser.TAG_LANG, 14);
            link = new PseudoClassIdents("link", 15);
            visited = new PseudoClassIdents(NativeConstants.VISITED, 16);
            hover = new PseudoClassIdents("hover", 17);
            active = new PseudoClassIdents("active", 18);
            focus = new PseudoClassIdents(AddFriendActivityConfig.TYPE_FOCUS, 19);
            enabled = new PseudoClassIdents(SapiOptions.KEY_CACHE_ENABLED, 20);
            disabled = new PseudoClassIdents("disabled", 21);
            checked = new PseudoClassIdents("checked", 22);
            indeterminate = new PseudoClassIdents("indeterminate", 23);
            PseudoClassIdents pseudoClassIdents = new PseudoClassIdents("UNSUPPORTED", 24);
            UNSUPPORTED = pseudoClassIdents;
            $VALUES = new PseudoClassIdents[]{target, root, nth_child, nth_last_child, nth_of_type, nth_last_of_type, first_child, last_child, first_of_type, last_of_type, only_child, only_of_type, empty, not, lang, link, visited, hover, active, focus, enabled, disabled, checked, indeterminate, pseudoClassIdents};
            cache = new HashMap();
            for (PseudoClassIdents pseudoClassIdents2 : values()) {
                if (pseudoClassIdents2 != UNSUPPORTED) {
                    cache.put(pseudoClassIdents2.name().replace('_', SignatureImpl.SEP), pseudoClassIdents2);
                }
            }
        }

        public PseudoClassIdents(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PseudoClassIdents fromString(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                PseudoClassIdents pseudoClassIdents = cache.get(str);
                if (pseudoClassIdents != null) {
                    return pseudoClassIdents;
                }
                return UNSUPPORTED;
            }
            return (PseudoClassIdents) invokeL.objValue;
        }

        public static PseudoClassIdents valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (PseudoClassIdents) Enum.valueOf(PseudoClassIdents.class, str);
            }
            return (PseudoClassIdents) invokeL.objValue;
        }

        public static PseudoClassIdents[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (PseudoClassIdents[]) $VALUES.clone();
            }
            return (PseudoClassIdents[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class Source {
        public static final /* synthetic */ Source[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Source Document;
        public static final Source RenderOptions;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1869991353, "Lcom/caverock/androidsvg/CSSParser$Source;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1869991353, "Lcom/caverock/androidsvg/CSSParser$Source;");
                    return;
                }
            }
            Document = new Source("Document", 0);
            Source source = new Source("RenderOptions", 1);
            RenderOptions = source;
            $VALUES = new Source[]{Document, source};
        }

        public Source(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Source valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Source) Enum.valueOf(Source.class, str);
            }
            return (Source) invokeL.objValue;
        }

        public static Source[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Source[]) $VALUES.clone();
            }
            return (Source[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1172510899, "Lcom/caverock/androidsvg/CSSParser$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1172510899, "Lcom/caverock/androidsvg/CSSParser$a;");
                    return;
                }
            }
            int[] iArr = new int[PseudoClassIdents.values().length];
            b = iArr;
            try {
                iArr[PseudoClassIdents.first_child.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[PseudoClassIdents.last_child.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[PseudoClassIdents.only_child.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[PseudoClassIdents.first_of_type.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[PseudoClassIdents.last_of_type.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[PseudoClassIdents.only_of_type.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[PseudoClassIdents.root.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[PseudoClassIdents.empty.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[PseudoClassIdents.nth_child.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[PseudoClassIdents.nth_last_child.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[PseudoClassIdents.nth_of_type.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[PseudoClassIdents.nth_last_of_type.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[PseudoClassIdents.not.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                b[PseudoClassIdents.target.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                b[PseudoClassIdents.lang.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                b[PseudoClassIdents.link.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                b[PseudoClassIdents.visited.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                b[PseudoClassIdents.hover.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                b[PseudoClassIdents.active.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                b[PseudoClassIdents.focus.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                b[PseudoClassIdents.enabled.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                b[PseudoClassIdents.disabled.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                b[PseudoClassIdents.checked.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                b[PseudoClassIdents.indeterminate.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            int[] iArr2 = new int[AttribOp.values().length];
            a = iArr2;
            try {
                iArr2[AttribOp.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[AttribOp.INCLUDES.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[AttribOp.DASHMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final AttribOp b;
        public final String c;

        public b(String str, AttribOp attribOp, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, attribOp, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = attribOp;
            this.c = str2;
        }
    }

    /* loaded from: classes9.dex */
    public static class e implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public boolean c;
        public boolean d;
        public String e;

        public e(int i, int i2, boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
            this.c = z;
            this.d = z2;
            this.e = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.d
        public boolean a(m mVar, SVG.j0 j0Var) {
            InterceptResult invokeLL;
            String str;
            int i;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mVar, j0Var)) == null) {
                if (this.d && this.e == null) {
                    str = j0Var.n();
                } else {
                    str = this.e;
                }
                SVG.h0 h0Var = j0Var.b;
                if (h0Var != null) {
                    Iterator<SVG.l0> it = h0Var.getChildren().iterator();
                    i = 0;
                    i2 = 0;
                    while (it.hasNext()) {
                        SVG.j0 j0Var2 = (SVG.j0) it.next();
                        if (j0Var2 == j0Var) {
                            i = i2;
                        }
                        if (str == null || j0Var2.n().equals(str)) {
                            i2++;
                        }
                    }
                } else {
                    i = 0;
                    i2 = 1;
                }
                if (this.c) {
                    i3 = i + 1;
                } else {
                    i3 = i2 - i;
                }
                int i4 = this.a;
                if (i4 == 0) {
                    if (i3 != this.b) {
                        return false;
                    }
                    return true;
                }
                int i5 = this.b;
                if ((i3 - i5) % i4 != 0) {
                    return false;
                }
                if (Integer.signum(i3 - i5) != 0 && Integer.signum(i3 - this.b) != Integer.signum(this.a)) {
                    return false;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.c) {
                    str = "";
                } else {
                    str = "last-";
                }
                if (this.d) {
                    return String.format("nth-%schild(%dn%+d of type <%s>)", str, Integer.valueOf(this.a), Integer.valueOf(this.b), this.e);
                }
                return String.format("nth-%schild(%dn%+d)", str, Integer.valueOf(this.a), Integer.valueOf(this.b));
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class f implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? SchemeCollecter.CLASSIFY_EMPTY : (String) invokeV.objValue;
        }

        public f() {
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

        public /* synthetic */ f(a aVar) {
            this();
        }

        @Override // com.caverock.androidsvg.CSSParser.d
        public boolean a(m mVar, SVG.j0 j0Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mVar, j0Var)) == null) {
                if (!(j0Var instanceof SVG.h0) || ((SVG.h0) j0Var).getChildren().size() == 0) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class g implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<o> a;

        public g(List<o> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // com.caverock.androidsvg.CSSParser.d
        public boolean a(m mVar, SVG.j0 j0Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mVar, j0Var)) == null) {
                for (o oVar : this.a) {
                    if (CSSParser.l(mVar, oVar, j0Var)) {
                        return false;
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i = Integer.MIN_VALUE;
                for (o oVar : this.a) {
                    int i2 = oVar.b;
                    if (i2 > i) {
                        i = i2;
                    }
                }
                return i;
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "not(" + this.a + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class h implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        @Override // com.caverock.androidsvg.CSSParser.d
        public boolean a(m mVar, SVG.j0 j0Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mVar, j0Var)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public h(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class i implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;

        public i(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.d
        public boolean a(m mVar, SVG.j0 j0Var) {
            InterceptResult invokeLL;
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mVar, j0Var)) == null) {
                if (this.a && this.b == null) {
                    str = j0Var.n();
                } else {
                    str = this.b;
                }
                SVG.h0 h0Var = j0Var.b;
                if (h0Var != null) {
                    Iterator<SVG.l0> it = h0Var.getChildren().iterator();
                    i = 0;
                    while (it.hasNext()) {
                        SVG.j0 j0Var2 = (SVG.j0) it.next();
                        if (str == null || j0Var2.n().equals(str)) {
                            i++;
                        }
                    }
                } else {
                    i = 1;
                }
                if (i != 1) {
                    return false;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a) {
                    return String.format("only-of-type <%s>", this.b);
                }
                return String.format("only-child", new Object[0]);
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class j implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "root" : (String) invokeV.objValue;
        }

        public j() {
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

        public /* synthetic */ j(a aVar) {
            this();
        }

        @Override // com.caverock.androidsvg.CSSParser.d
        public boolean a(m mVar, SVG.j0 j0Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mVar, j0Var)) == null) {
                if (j0Var.b == null) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class k implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "target" : (String) invokeV.objValue;
        }

        public k() {
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

        public /* synthetic */ k(a aVar) {
            this();
        }

        @Override // com.caverock.androidsvg.CSSParser.d
        public boolean a(m mVar, SVG.j0 j0Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mVar, j0Var)) == null) {
                if (mVar == null || j0Var != mVar.a) {
                    return false;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o a;
        public SVG.Style b;
        public Source c;

        public l(o oVar, SVG.Style style, Source source) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, style, source};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = null;
            this.a = oVar;
            this.b = style;
            this.c = source;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return String.valueOf(this.a) + " {...} (src=" + this.c + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SVG.j0 a;

        public m() {
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

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                SVG.j0 j0Var = this.a;
                if (j0Var != null) {
                    return String.format("<%s id=\"%s\">", j0Var.n(), this.a.c);
                }
                return "";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<l> a;

        public n() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
        }

        public List<l> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a;
            }
            return (List) invokeV.objValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                List<l> list = this.a;
                if (list != null && !list.isEmpty()) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                List<l> list = this.a;
                if (list != null) {
                    return list.size();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public void a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
                if (this.a == null) {
                    this.a = new ArrayList();
                }
                for (int i = 0; i < this.a.size(); i++) {
                    if (this.a.get(i).a.b > lVar.a.b) {
                        this.a.add(i, lVar);
                        return;
                    }
                }
                this.a.add(lVar);
            }
        }

        public void b(n nVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar) != null) || nVar.a == null) {
                return;
            }
            if (this.a == null) {
                this.a = new ArrayList(nVar.a.size());
            }
            for (l lVar : nVar.a) {
                a(lVar);
            }
        }

        public void e(Source source) {
            List<l> list;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048580, this, source) != null) || (list = this.a) == null) {
                return;
            }
            Iterator<l> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().c == source) {
                    it.remove();
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.a == null) {
                    return "";
                }
                StringBuilder sb = new StringBuilder();
                for (l lVar : this.a) {
                    sb.append(lVar.toString());
                    sb.append('\n');
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<p> a;
        public int b;

        public o() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = 0;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b += 1000;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b++;
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b += 1000000;
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                List<p> list = this.a;
                if (list != null && !list.isEmpty()) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                List<p> list = this.a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        public /* synthetic */ o(a aVar) {
            this();
        }

        public void a(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
                if (this.a == null) {
                    this.a = new ArrayList();
                }
                this.a.add(pVar);
            }
        }

        public p e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                return this.a.get(i);
            }
            return (p) invokeI.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (p pVar : this.a) {
                    sb.append(pVar);
                    sb.append(WebvttCueParser.CHAR_SPACE);
                }
                sb.append('[');
                sb.append(this.b);
                sb.append(']');
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Combinator a;
        public String b;
        public List<b> c;
        public List<d> d;

        public p(Combinator combinator, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {combinator, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.a = combinator == null ? Combinator.DESCENDANT : combinator;
            this.b = str;
        }

        public void a(String str, AttribOp attribOp, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, attribOp, str2) == null) {
                if (this.c == null) {
                    this.c = new ArrayList();
                }
                this.c.add(new b(str, attribOp, str2));
            }
        }

        public void b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
                if (this.d == null) {
                    this.d = new ArrayList();
                }
                this.d.add(dVar);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                StringBuilder sb = new StringBuilder();
                Combinator combinator = this.a;
                if (combinator == Combinator.CHILD) {
                    sb.append("> ");
                } else if (combinator == Combinator.FOLLOWS) {
                    sb.append("+ ");
                }
                String str = this.b;
                if (str == null) {
                    str = "*";
                }
                sb.append(str);
                List<b> list = this.c;
                if (list != null) {
                    for (b bVar : list) {
                        sb.append('[');
                        sb.append(bVar.a);
                        int i = a.a[bVar.b.ordinal()];
                        if (i != 1) {
                            if (i != 2) {
                                if (i == 3) {
                                    sb.append("|=");
                                    sb.append(bVar.c);
                                }
                            } else {
                                sb.append("~=");
                                sb.append(bVar.c);
                            }
                        } else {
                            sb.append('=');
                            sb.append(bVar.c);
                        }
                        sb.append(']');
                    }
                }
                List<d> list2 = this.d;
                if (list2 != null) {
                    for (d dVar : list2) {
                        sb.append(':');
                        sb.append(dVar);
                    }
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    public CSSParser(MediaType mediaType, Source source) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaType, source};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = mediaType;
        this.b = source;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CSSParser(Source source) {
        this(MediaType.screen, source);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {source};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((MediaType) objArr2[0], (Source) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static List<String> f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            c cVar = new c(str);
            ArrayList arrayList = null;
            while (!cVar.h()) {
                String r = cVar.r();
                if (r != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(r);
                    cVar.A();
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<MediaType> h(c cVar) {
        InterceptResult invokeL;
        String w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, cVar)) == null) {
            ArrayList arrayList = new ArrayList();
            while (!cVar.h() && (w = cVar.w()) != null) {
                try {
                    arrayList.add(MediaType.valueOf(w));
                } catch (IllegalArgumentException unused) {
                }
                if (!cVar.z()) {
                    break;
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void o(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            int i2 = 0;
            while (!cVar.h()) {
                int intValue = cVar.l().intValue();
                if (intValue == 59 && i2 == 0) {
                    return;
                }
                if (intValue == 123) {
                    i2++;
                } else if (intValue == 125 && i2 > 0 && i2 - 1 == 0) {
                    return;
                }
            }
        }
    }

    public static int a(List<SVG.h0> list, int i2, SVG.j0 j0Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, list, i2, j0Var)) == null) {
            int i3 = 0;
            if (i2 < 0) {
                return 0;
            }
            SVG.h0 h0Var = list.get(i2);
            SVG.h0 h0Var2 = j0Var.b;
            if (h0Var != h0Var2) {
                return -1;
            }
            for (SVG.l0 l0Var : h0Var2.getChildren()) {
                if (l0Var == j0Var) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        return invokeLIL.intValue;
    }

    public static boolean b(String str, MediaType mediaType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, mediaType)) == null) {
            c cVar = new c(str);
            cVar.A();
            return c(h(cVar), mediaType);
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(List<MediaType> list, MediaType mediaType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, mediaType)) == null) {
            for (MediaType mediaType2 : list) {
                if (mediaType2 != MediaType.all) {
                    if (mediaType2 == mediaType) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void p(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, objArr) == null) {
            Log.w("CSSParser", String.format(str, objArr));
        }
    }

    public static boolean k(m mVar, o oVar, int i2, List<SVG.h0> list, int i3, SVG.j0 j0Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{mVar, oVar, Integer.valueOf(i2), list, Integer.valueOf(i3), j0Var})) == null) {
            p e2 = oVar.e(i2);
            if (!n(mVar, e2, list, i3, j0Var)) {
                return false;
            }
            Combinator combinator = e2.a;
            if (combinator == Combinator.DESCENDANT) {
                if (i2 == 0) {
                    return true;
                }
                while (i3 >= 0) {
                    if (m(mVar, oVar, i2 - 1, list, i3)) {
                        return true;
                    }
                    i3--;
                }
                return false;
            } else if (combinator == Combinator.CHILD) {
                return m(mVar, oVar, i2 - 1, list, i3);
            } else {
                int a2 = a(list, i3, j0Var);
                if (a2 <= 0) {
                    return false;
                }
                return k(mVar, oVar, i2 - 1, list, i3, (SVG.j0) j0Var.b.getChildren().get(a2 - 1));
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean l(m mVar, o oVar, SVG.j0 j0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, mVar, oVar, j0Var)) == null) {
            ArrayList arrayList = new ArrayList();
            for (SVG.h0 h0Var = j0Var.b; h0Var != null; h0Var = ((SVG.l0) h0Var).b) {
                arrayList.add(0, h0Var);
            }
            int size = arrayList.size() - 1;
            if (oVar.g() == 1) {
                return n(mVar, oVar.e(0), arrayList, size, j0Var);
            }
            return k(mVar, oVar, oVar.g() - 1, arrayList, size, j0Var);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean m(m mVar, o oVar, int i2, List<SVG.h0> list, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{mVar, oVar, Integer.valueOf(i2), list, Integer.valueOf(i3)})) == null) {
            p e2 = oVar.e(i2);
            SVG.j0 j0Var = (SVG.j0) list.get(i3);
            if (!n(mVar, e2, list, i3, j0Var)) {
                return false;
            }
            Combinator combinator = e2.a;
            if (combinator == Combinator.DESCENDANT) {
                if (i2 == 0) {
                    return true;
                }
                while (i3 > 0) {
                    i3--;
                    if (m(mVar, oVar, i2 - 1, list, i3)) {
                        return true;
                    }
                }
                return false;
            } else if (combinator == Combinator.CHILD) {
                return m(mVar, oVar, i2 - 1, list, i3 - 1);
            } else {
                int a2 = a(list, i3, j0Var);
                if (a2 <= 0) {
                    return false;
                }
                return k(mVar, oVar, i2 - 1, list, i3, (SVG.j0) j0Var.b.getChildren().get(a2 - 1));
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean n(m mVar, p pVar, List<SVG.h0> list, int i2, SVG.j0 j0Var) {
        InterceptResult invokeCommon;
        List<String> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{mVar, pVar, list, Integer.valueOf(i2), j0Var})) == null) {
            String str = pVar.b;
            if (str != null && !str.equals(j0Var.n().toLowerCase(Locale.US))) {
                return false;
            }
            List<b> list3 = pVar.c;
            if (list3 != null) {
                for (b bVar : list3) {
                    String str2 = bVar.a;
                    char c2 = 65535;
                    int hashCode = str2.hashCode();
                    if (hashCode != 3355) {
                        if (hashCode == 94742904 && str2.equals("class")) {
                            c2 = 1;
                        }
                    } else if (str2.equals("id")) {
                        c2 = 0;
                    }
                    if (c2 != 0) {
                        if (c2 != 1 || (list2 = j0Var.g) == null || !list2.contains(bVar.c)) {
                            return false;
                        }
                    } else if (!bVar.c.equals(j0Var.c)) {
                        return false;
                    }
                }
            }
            List<d> list4 = pVar.d;
            if (list4 != null) {
                for (d dVar : list4) {
                    if (!dVar.a(mVar, j0Var)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public n d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            c cVar = new c(str);
            cVar.A();
            return j(cVar);
        }
        return (n) invokeL.objValue;
    }

    public final void e(n nVar, c cVar) throws CSSParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar, cVar) == null) {
            String H = cVar.H();
            cVar.A();
            if (H != null) {
                if (!this.c && H.equals("media")) {
                    List<MediaType> h2 = h(cVar);
                    if (cVar.f('{')) {
                        cVar.A();
                        if (c(h2, this.a)) {
                            this.c = true;
                            nVar.b(j(cVar));
                            this.c = false;
                        } else {
                            j(cVar);
                        }
                        if (!cVar.h() && !cVar.f('}')) {
                            throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
                        }
                    } else {
                        throw new CSSParseException("Invalid @media rule: missing rule set");
                    }
                } else if (!this.c && H.equals(ShareDirectionType.IMPORT)) {
                    String N = cVar.N();
                    if (N == null) {
                        N = cVar.F();
                    }
                    if (N != null) {
                        cVar.A();
                        List<MediaType> h3 = h(cVar);
                        if (!cVar.h() && !cVar.f(WebvttCueParser.CHAR_SEMI_COLON)) {
                            throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
                        }
                        if (SVG.g() != null && c(h3, this.a)) {
                            String b2 = SVG.g().b(N);
                            if (b2 == null) {
                                return;
                            }
                            nVar.b(d(b2));
                        }
                    } else {
                        throw new CSSParseException("Invalid @import rule: expected string or url()");
                    }
                } else {
                    p("Ignoring @%s rule", H);
                    o(cVar);
                }
                cVar.A();
                return;
            }
            throw new CSSParseException("Invalid '@' rule");
        }
    }

    public final SVG.Style g(c cVar) throws CSSParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
            SVG.Style style = new SVG.Style();
            do {
                String H = cVar.H();
                cVar.A();
                if (cVar.f(':')) {
                    cVar.A();
                    String J = cVar.J();
                    if (J != null) {
                        cVar.A();
                        if (cVar.f('!')) {
                            cVar.A();
                            if (cVar.g("important")) {
                                cVar.A();
                            } else {
                                throw new CSSParseException("Malformed rule set: found unexpected '!'");
                            }
                        }
                        cVar.f(WebvttCueParser.CHAR_SEMI_COLON);
                        SVGParser.S0(style, H, J);
                        cVar.A();
                        if (cVar.h()) {
                            break;
                        }
                    } else {
                        throw new CSSParseException("Expected property value");
                    }
                } else {
                    throw new CSSParseException("Expected ':'");
                }
            } while (!cVar.f('}'));
            return style;
        }
        return (SVG.Style) invokeL.objValue;
    }

    public final boolean i(n nVar, c cVar) throws CSSParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, nVar, cVar)) == null) {
            List<o> L = cVar.L();
            if (L != null && !L.isEmpty()) {
                if (cVar.f('{')) {
                    cVar.A();
                    SVG.Style g2 = g(cVar);
                    cVar.A();
                    for (o oVar : L) {
                        nVar.a(new l(oVar, g2, this.b));
                    }
                    return true;
                }
                throw new CSSParseException("Malformed rule block: expected '{'");
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final n j(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
            n nVar = new n();
            while (!cVar.h()) {
                try {
                    if (!cVar.g("<!--") && !cVar.g("-->")) {
                        if (cVar.f('@')) {
                            e(nVar, cVar);
                        } else if (!i(nVar, cVar)) {
                            break;
                        }
                    }
                } catch (CSSParseException e2) {
                    Log.e("CSSParser", "CSS parser terminated early due to error: " + e2.getMessage());
                }
            }
            return nVar;
        }
        return (n) invokeL.objValue;
    }
}
