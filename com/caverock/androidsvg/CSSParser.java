package com.caverock.androidsvg;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.services.vod.VodClient;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.text.Typography;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.xml.sax.SAXException;
/* loaded from: classes9.dex */
public class CSSParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MediaType f68552a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68553b;

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

        public AttribOp(String str, int i2) {
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

        public static AttribOp valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AttribOp) Enum.valueOf(AttribOp.class, str) : (AttribOp) invokeL.objValue;
        }

        public static AttribOp[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AttribOp[]) $VALUES.clone() : (AttribOp[]) invokeV.objValue;
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

        public Combinator(String str, int i2) {
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

        public static Combinator valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Combinator) Enum.valueOf(Combinator.class, str) : (Combinator) invokeL.objValue;
        }

        public static Combinator[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Combinator[]) $VALUES.clone() : (Combinator[]) invokeV.objValue;
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
        public static final MediaType tty;

        /* renamed from: tv  reason: collision with root package name */
        public static final MediaType f68554tv;
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
            tty = new MediaType("tty", 8);
            MediaType mediaType = new MediaType("tv", 9);
            f68554tv = mediaType;
            $VALUES = new MediaType[]{all, aural, braille, embossed, handheld, print, projection, screen, tty, mediaType};
        }

        public MediaType(String str, int i2) {
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

        public static MediaType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MediaType) Enum.valueOf(MediaType.class, str) : (MediaType) invokeL.objValue;
        }

        public static MediaType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MediaType[]) $VALUES.clone() : (MediaType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68555a;
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
            int[] iArr = new int[AttribOp.values().length];
            f68555a = iArr;
            try {
                iArr[AttribOp.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68555a[AttribOp.INCLUDES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68555a[AttribOp.DASHMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f68556a;

        /* renamed from: b  reason: collision with root package name */
        public AttribOp f68557b;

        /* renamed from: c  reason: collision with root package name */
        public String f68558c;

        public b(String str, AttribOp attribOp, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, attribOp, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68556a = null;
            this.f68558c = null;
            this.f68556a = str;
            this.f68557b = attribOp;
            this.f68558c = str2;
        }
    }

    /* loaded from: classes9.dex */
    public static class c extends SVGParser.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:87:0x0158, code lost:
            if (r4 == null) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x015a, code lost:
            r11.a(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x015d, code lost:
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x015e, code lost:
            r10.f68645b = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0160, code lost:
            return false;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0158 A[EDGE_INSN: B:96:0x0158->B:87:0x0158 ?: BREAK  , SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean A(f fVar) throws SAXException {
            InterceptResult invokeL;
            Combinator combinator;
            g gVar;
            AttribOp attribOp;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, fVar)) != null) {
                return invokeL.booleanValue;
            }
            if (g()) {
                return false;
            }
            int i2 = this.f68645b;
            if (!fVar.f()) {
                if (e(Typography.greater)) {
                    combinator = Combinator.CHILD;
                    w();
                } else if (e('+')) {
                    combinator = Combinator.FOLLOWS;
                    w();
                }
                if (!e('*')) {
                    gVar = new g(combinator, null);
                } else {
                    String y = y();
                    if (y != null) {
                        g gVar2 = new g(combinator, y);
                        fVar.c();
                        gVar = gVar2;
                    } else {
                        gVar = null;
                    }
                }
                while (true) {
                    if (!g()) {
                        if (e('.')) {
                            if (gVar == null) {
                                gVar = new g(combinator, null);
                            }
                            String y2 = y();
                            if (y2 != null) {
                                gVar.a(DealIntentService.KEY_CLASS, AttribOp.EQUALS, y2);
                                fVar.b();
                            } else {
                                throw new SAXException("Invalid \".class\" selector in <style> element");
                            }
                        } else {
                            if (e('#')) {
                                if (gVar == null) {
                                    gVar = new g(combinator, null);
                                }
                                String y3 = y();
                                if (y3 != null) {
                                    gVar.a("id", AttribOp.EQUALS, y3);
                                    fVar.d();
                                } else {
                                    throw new SAXException("Invalid \"#id\" selector in <style> element");
                                }
                            }
                            if (gVar == null) {
                                break;
                            } else if (e('[')) {
                                w();
                                String y4 = y();
                                if (y4 != null) {
                                    w();
                                    if (e(com.alipay.sdk.encrypt.a.f35773h)) {
                                        attribOp = AttribOp.EQUALS;
                                    } else if (f("~=")) {
                                        attribOp = AttribOp.INCLUDES;
                                    } else {
                                        attribOp = f("|=") ? AttribOp.DASHMATCH : null;
                                    }
                                    if (attribOp != null) {
                                        w();
                                        str = x();
                                        if (str != null) {
                                            w();
                                        } else {
                                            throw new SAXException("Invalid attribute selector in <style> element");
                                        }
                                    } else {
                                        str = null;
                                    }
                                    if (e(']')) {
                                        if (attribOp == null) {
                                            attribOp = AttribOp.EXISTS;
                                        }
                                        gVar.a(y4, attribOp, str);
                                        fVar.b();
                                    } else {
                                        throw new SAXException("Invalid attribute selector in <style> element");
                                    }
                                } else {
                                    throw new SAXException("Invalid attribute selector in <style> element");
                                }
                            } else if (e(':')) {
                                int i3 = this.f68645b;
                                if (y() != null) {
                                    if (e('(')) {
                                        w();
                                        if (y() != null) {
                                            w();
                                            if (!e(')')) {
                                                this.f68645b = i3 - 1;
                                            }
                                        }
                                    }
                                    gVar.b(this.f68644a.substring(i3, this.f68645b));
                                    fVar.b();
                                }
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
            combinator = null;
            if (!e('*')) {
            }
            while (true) {
                if (!g()) {
                }
            }
        }

        public final int B() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (g()) {
                    return this.f68645b;
                }
                int i3 = this.f68645b;
                int charAt = this.f68644a.charAt(i3);
                if (charAt == 45) {
                    charAt = a();
                }
                if ((charAt < 65 || charAt > 90) && ((charAt < 97 || charAt > 122) && charAt != 95)) {
                    i2 = i3;
                } else {
                    int a2 = a();
                    while (true) {
                        if ((a2 < 65 || a2 > 90) && ((a2 < 97 || a2 > 122) && !((a2 >= 48 && a2 <= 57) || a2 == 45 || a2 == 95))) {
                            break;
                        }
                        a2 = a();
                    }
                    i2 = this.f68645b;
                }
                this.f68645b = i3;
                return i2;
            }
            return invokeV.intValue;
        }

        public final String x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (g()) {
                    return null;
                }
                String p = p();
                return p != null ? p : y();
            }
            return (String) invokeV.objValue;
        }

        public String y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int B = B();
                int i2 = this.f68645b;
                if (B == i2) {
                    return null;
                }
                String substring = this.f68644a.substring(i2, B);
                this.f68645b = B;
                return substring;
            }
            return (String) invokeV.objValue;
        }

        public String z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (g()) {
                    return null;
                }
                int i2 = this.f68645b;
                int charAt = this.f68644a.charAt(i2);
                int i3 = i2;
                while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !i(charAt)) {
                    if (!j(charAt)) {
                        i3 = this.f68645b + 1;
                    }
                    charAt = a();
                }
                if (this.f68645b > i2) {
                    return this.f68644a.substring(i2, i3);
                }
                this.f68645b = i2;
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f f68559a;

        /* renamed from: b  reason: collision with root package name */
        public SVG.Style f68560b;

        public d(f fVar, SVG.Style style) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, style};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68559a = null;
            this.f68560b = null;
            this.f68559a = fVar;
            this.f68560b = style;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.f68559a + " {}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<d> f68561a;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68561a = null;
        }

        public void a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                if (this.f68561a == null) {
                    this.f68561a = new ArrayList();
                }
                for (int i2 = 0; i2 < this.f68561a.size(); i2++) {
                    if (this.f68561a.get(i2).f68559a.f68563b > dVar.f68559a.f68563b) {
                        this.f68561a.add(i2, dVar);
                        return;
                    }
                }
                this.f68561a.add(dVar);
            }
        }

        public void b(e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar.f68561a == null) {
                return;
            }
            if (this.f68561a == null) {
                this.f68561a = new ArrayList(eVar.f68561a.size());
            }
            for (d dVar : eVar.f68561a) {
                this.f68561a.add(dVar);
            }
        }

        public List<d> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68561a : (List) invokeV.objValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                List<d> list = this.f68561a;
                return list == null || list.isEmpty();
            }
            return invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.f68561a == null) {
                    return "";
                }
                StringBuilder sb = new StringBuilder();
                for (d dVar : this.f68561a) {
                    sb.append(dVar.toString());
                    sb.append('\n');
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<g> f68562a;

        /* renamed from: b  reason: collision with root package name */
        public int f68563b;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68562a = null;
            this.f68563b = 0;
        }

        public void a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                if (this.f68562a == null) {
                    this.f68562a = new ArrayList();
                }
                this.f68562a.add(gVar);
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f68563b += 100;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f68563b++;
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f68563b += 10000;
            }
        }

        public g e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f68562a.get(i2) : (g) invokeI.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                List<g> list = this.f68562a;
                if (list == null) {
                    return true;
                }
                return list.isEmpty();
            }
            return invokeV.booleanValue;
        }

        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                List<g> list = this.f68562a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (g gVar : this.f68562a) {
                    sb.append(gVar);
                    sb.append(' ');
                }
                sb.append('(');
                sb.append(this.f68563b);
                sb.append(')');
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Combinator f68564a;

        /* renamed from: b  reason: collision with root package name */
        public String f68565b;

        /* renamed from: c  reason: collision with root package name */
        public List<b> f68566c;

        /* renamed from: d  reason: collision with root package name */
        public List<String> f68567d;

        public g(Combinator combinator, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {combinator, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68564a = null;
            this.f68565b = null;
            this.f68566c = null;
            this.f68567d = null;
            this.f68564a = combinator == null ? Combinator.DESCENDANT : combinator;
            this.f68565b = str;
        }

        public void a(String str, AttribOp attribOp, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, attribOp, str2) == null) {
                if (this.f68566c == null) {
                    this.f68566c = new ArrayList();
                }
                this.f68566c.add(new b(str, attribOp, str2));
            }
        }

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f68567d == null) {
                    this.f68567d = new ArrayList();
                }
                this.f68567d.add(str);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                StringBuilder sb = new StringBuilder();
                Combinator combinator = this.f68564a;
                if (combinator == Combinator.CHILD) {
                    sb.append("> ");
                } else if (combinator == Combinator.FOLLOWS) {
                    sb.append("+ ");
                }
                String str = this.f68565b;
                if (str == null) {
                    str = "*";
                }
                sb.append(str);
                List<b> list = this.f68566c;
                if (list != null) {
                    for (b bVar : list) {
                        sb.append('[');
                        sb.append(bVar.f68556a);
                        int i2 = a.f68555a[bVar.f68557b.ordinal()];
                        if (i2 == 1) {
                            sb.append(com.alipay.sdk.encrypt.a.f35773h);
                            sb.append(bVar.f68558c);
                        } else if (i2 == 2) {
                            sb.append("~=");
                            sb.append(bVar.f68558c);
                        } else if (i2 == 3) {
                            sb.append("|=");
                            sb.append(bVar.f68558c);
                        }
                        sb.append(']');
                    }
                }
                List<String> list2 = this.f68567d;
                if (list2 != null) {
                    for (String str2 : list2) {
                        sb.append(':');
                        sb.append(str2);
                    }
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    public CSSParser(MediaType mediaType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68552a = null;
        this.f68553b = false;
        this.f68552a = mediaType;
    }

    public static int a(List<SVG.h0> list, int i2, SVG.j0 j0Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, list, i2, j0Var)) == null) {
            if (i2 < 0) {
                return -1;
            }
            SVG.h0 h0Var = list.get(i2);
            SVG.h0 h0Var2 = j0Var.f68612b;
            if (h0Var != h0Var2) {
                return -1;
            }
            int i3 = 0;
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

    public static boolean b(String str, MediaType mediaType) throws SAXException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, mediaType)) == null) {
            c cVar = new c(str);
            cVar.w();
            List<MediaType> h2 = h(cVar);
            if (cVar.g()) {
                return c(h2, mediaType);
            }
            throw new SAXException("Invalid @media type list");
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(List<MediaType> list, MediaType mediaType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, list, mediaType)) == null) {
            for (MediaType mediaType2 : list) {
                if (mediaType2 == MediaType.all) {
                    return true;
                }
                if (mediaType2 == mediaType) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<String> f(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            c cVar = new c(str);
            ArrayList arrayList = null;
            while (!cVar.g()) {
                String y = cVar.y();
                if (y != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(y);
                    cVar.w();
                } else {
                    throw new SAXException("Invalid value for \"class\" attribute: " + str);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<MediaType> h(c cVar) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, cVar)) == null) {
            ArrayList arrayList = new ArrayList();
            while (!cVar.g()) {
                try {
                    arrayList.add(MediaType.valueOf(cVar.r(',')));
                    if (!cVar.v()) {
                        break;
                    }
                } catch (IllegalArgumentException unused) {
                    throw new SAXException("Invalid @media type list");
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static boolean l(f fVar, int i2, List<SVG.h0> list, int i3, SVG.j0 j0Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{fVar, Integer.valueOf(i2), list, Integer.valueOf(i3), j0Var})) == null) {
            g e2 = fVar.e(i2);
            if (o(e2, list, i3, j0Var)) {
                Combinator combinator = e2.f68564a;
                if (combinator != Combinator.DESCENDANT) {
                    if (combinator == Combinator.CHILD) {
                        return n(fVar, i2 - 1, list, i3);
                    }
                    int a2 = a(list, i3, j0Var);
                    if (a2 <= 0) {
                        return false;
                    }
                    return l(fVar, i2 - 1, list, i3, (SVG.j0) j0Var.f68612b.getChildren().get(a2 - 1));
                } else if (i2 == 0) {
                    return true;
                } else {
                    while (i3 >= 0) {
                        if (n(fVar, i2 - 1, list, i3)) {
                            return true;
                        }
                        i3--;
                    }
                    return false;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean m(f fVar, SVG.j0 j0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, fVar, j0Var)) == null) {
            ArrayList arrayList = new ArrayList();
            for (SVG.h0 h0Var = j0Var.f68612b; h0Var != null; h0Var = ((SVG.l0) h0Var).f68612b) {
                arrayList.add(0, h0Var);
            }
            int size = arrayList.size() - 1;
            if (fVar.g() == 1) {
                return o(fVar.e(0), arrayList, size, j0Var);
            }
            return l(fVar, fVar.g() - 1, arrayList, size, j0Var);
        }
        return invokeLL.booleanValue;
    }

    public static boolean n(f fVar, int i2, List<SVG.h0> list, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{fVar, Integer.valueOf(i2), list, Integer.valueOf(i3)})) == null) {
            g e2 = fVar.e(i2);
            SVG.j0 j0Var = (SVG.j0) list.get(i3);
            if (o(e2, list, i3, j0Var)) {
                Combinator combinator = e2.f68564a;
                if (combinator != Combinator.DESCENDANT) {
                    if (combinator == Combinator.CHILD) {
                        return n(fVar, i2 - 1, list, i3 - 1);
                    }
                    int a2 = a(list, i3, j0Var);
                    if (a2 <= 0) {
                        return false;
                    }
                    return l(fVar, i2 - 1, list, i3, (SVG.j0) j0Var.f68612b.getChildren().get(a2 - 1));
                } else if (i2 == 0) {
                    return true;
                } else {
                    while (i3 > 0) {
                        i3--;
                        if (n(fVar, i2 - 1, list, i3)) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean o(g gVar, List<SVG.h0> list, int i2, SVG.j0 j0Var) {
        InterceptResult invokeLLIL;
        List<String> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65545, null, gVar, list, i2, j0Var)) == null) {
            String str = gVar.f68565b;
            if (str != null) {
                if (str.equalsIgnoreCase("G")) {
                    if (!(j0Var instanceof SVG.l)) {
                        return false;
                    }
                } else if (!gVar.f68565b.equals(j0Var.getClass().getSimpleName().toLowerCase(Locale.US))) {
                    return false;
                }
            }
            List<b> list3 = gVar.f68566c;
            if (list3 != null) {
                for (b bVar : list3) {
                    String str2 = bVar.f68556a;
                    if (str2 == "id") {
                        if (!bVar.f68558c.equals(j0Var.f68606c)) {
                            return false;
                        }
                    } else if (str2 != DealIntentService.KEY_CLASS || (list2 = j0Var.f68610g) == null || !list2.contains(bVar.f68558c)) {
                        return false;
                    }
                }
            }
            List<String> list4 = gVar.f68567d;
            if (list4 != null) {
                for (String str3 : list4) {
                    if (!str3.equals("first-child") || a(list, i2, j0Var) != 0) {
                        return false;
                    }
                    while (r5.hasNext()) {
                    }
                }
                return true;
            }
            return true;
        }
        return invokeLLIL.booleanValue;
    }

    public static void q(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, objArr) == null) {
            String.format(str, objArr);
        }
    }

    public e d(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            c cVar = new c(str);
            cVar.w();
            return j(cVar);
        }
        return (e) invokeL.objValue;
    }

    public final void e(e eVar, c cVar) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, cVar) == null) {
            String y = cVar.y();
            cVar.w();
            if (y != null) {
                if (!this.f68553b && y.equals(VodClient.PATH_MEDIA)) {
                    List<MediaType> h2 = h(cVar);
                    if (cVar.e(ExtendedMessageFormat.START_FE)) {
                        cVar.w();
                        if (c(h2, this.f68552a)) {
                            this.f68553b = true;
                            eVar.b(j(cVar));
                            this.f68553b = false;
                        } else {
                            j(cVar);
                        }
                        if (!cVar.e(ExtendedMessageFormat.END_FE)) {
                            throw new SAXException("Invalid @media rule: expected '}' at end of rule set");
                        }
                    } else {
                        throw new SAXException("Invalid @media rule: missing rule set");
                    }
                } else {
                    q("Ignoring @%s rule", y);
                    p(cVar);
                }
                cVar.w();
                return;
            }
            throw new SAXException("Invalid '@' rule in <style> element");
        }
    }

    public final SVG.Style g(c cVar) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
            SVG.Style style = new SVG.Style();
            do {
                String y = cVar.y();
                cVar.w();
                if (!cVar.e(':')) {
                    break;
                }
                cVar.w();
                String z = cVar.z();
                if (z == null) {
                    break;
                }
                cVar.w();
                if (cVar.e('!')) {
                    cVar.w();
                    if (cVar.f("important")) {
                        cVar.w();
                    } else {
                        throw new SAXException("Malformed rule set in <style> element: found unexpected '!'");
                    }
                }
                cVar.e(';');
                SVGParser.B0(style, y, z);
                cVar.w();
                if (cVar.e(ExtendedMessageFormat.END_FE)) {
                    return style;
                }
            } while (!cVar.g());
            throw new SAXException("Malformed rule set in <style> element");
        }
        return (SVG.Style) invokeL.objValue;
    }

    public final boolean i(e eVar, c cVar) throws SAXException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, cVar)) == null) {
            List<f> k = k(cVar);
            if (k == null || k.isEmpty()) {
                return false;
            }
            if (cVar.e(ExtendedMessageFormat.START_FE)) {
                cVar.w();
                SVG.Style g2 = g(cVar);
                cVar.w();
                for (f fVar : k) {
                    eVar.a(new d(fVar, g2));
                }
                return true;
            }
            throw new SAXException("Malformed rule block in <style> element: missing '{'");
        }
        return invokeLL.booleanValue;
    }

    public final e j(c cVar) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
            e eVar = new e();
            while (!cVar.g()) {
                if (!cVar.f("<!--") && !cVar.f("-->")) {
                    if (cVar.e('@')) {
                        e(eVar, cVar);
                    } else if (!i(eVar, cVar)) {
                        break;
                    }
                }
            }
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    public final List<f> k(c cVar) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            if (cVar.g()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(1);
            f fVar = new f();
            while (!cVar.g() && cVar.A(fVar)) {
                if (cVar.v()) {
                    arrayList.add(fVar);
                    fVar = new f();
                }
            }
            if (!fVar.f()) {
                arrayList.add(fVar);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void p(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            int i2 = 0;
            while (!cVar.g()) {
                int intValue = cVar.k().intValue();
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
}
