package com.kwai.video.ksvodplayerkit.HttpDns;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.ksvodplayerkit.b.c;
import com.kwai.video.ksvodplayerkit.b.h;
import com.kwai.video.ksvodplayerkit.b.i;
import com.kwai.video.ksvodplayerkit.b.j;
import com.kwai.video.ksvodplayerkit.b.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g<a> f39831a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f39832b;

    /* renamed from: c  reason: collision with root package name */
    public String f39833c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39834d;

    /* renamed from: e  reason: collision with root package name */
    public l f39835e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, j> f39836f;

    /* renamed from: g  reason: collision with root package name */
    public String f39837g;

    /* renamed from: h  reason: collision with root package name */
    public h f39838h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwai.video.ksvodplayerkit.b.c f39839i;
    public Map<String, com.kwai.video.ksvodplayerkit.b.f> j;
    public int k;

    public d(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39836f = new HashMap();
        this.j = new HashMap();
        this.k = 0;
        this.f39834d = false;
        this.k = 1;
        this.f39838h = hVar;
        a(hVar);
    }

    public d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f39836f = new HashMap();
        this.j = new HashMap();
        this.k = 0;
        this.f39834d = false;
        this.f39833c = str;
        this.k = 2;
        b(str);
    }

    public d(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f39836f = new HashMap();
        this.j = new HashMap();
        this.k = 0;
        this.f39834d = false;
        this.f39831a = new g<>();
        this.f39832b = list;
        a(list);
    }

    private void a(com.kwai.video.ksvodplayerkit.b.f fVar, a aVar, a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, fVar, aVar, aVar2) == null) {
            fVar.f39869a = aVar.f39826b;
            String str = aVar.f39825a;
            fVar.m = str;
            String str2 = fVar.f39872d;
            f fVar2 = aVar.f39827c;
            fVar.f39872d = str2.replace(str, fVar2 != null ? fVar2.f39843b : str);
            if (aVar2 != null) {
                fVar.f39874f = "";
            }
            this.f39839i.f39867d = aVar.f39825a;
        }
    }

    private void a(h hVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65540, this, hVar) == null) && this.f39835e == null) {
            l lVar = new l();
            this.f39835e = lVar;
            lVar.f39895a = new ArrayList();
            com.kwai.video.ksvodplayerkit.b.a aVar = new com.kwai.video.ksvodplayerkit.b.a();
            this.f39835e.f39895a.add(aVar);
            aVar.f39861a = 1L;
            aVar.f39862b = String.valueOf(hVar.f39878a);
            aVar.f39863c = new ArrayList();
            for (i iVar : hVar.f39879b) {
                if (iVar != null) {
                    j jVar = new j();
                    aVar.f39863c.add(jVar);
                    jVar.f39886a = iVar.f39881b;
                    jVar.f39889d = iVar.f39883d;
                    jVar.f39890e = iVar.f39885f;
                    jVar.f39891f = iVar.f39884e;
                    jVar.f39893h = iVar.f39882c;
                    ArrayList arrayList = new ArrayList();
                    for (String str : iVar.f39880a) {
                        try {
                            String b2 = com.kwai.video.ksvodplayerkit.c.a.b(str);
                            int i2 = 0;
                            for (f fVar : e.a().a(b2)) {
                                this.f39834d = true;
                                a aVar2 = new a(b2, str.replace(b2, fVar.f39843b), fVar);
                                arrayList.add(aVar2);
                                if (iVar.f39880a.size() > 1 && (i2 = i2 + 1) >= 2) {
                                    break;
                                }
                                this.f39836f.put(aVar2.f39826b, jVar);
                            }
                            this.f39836f.put(str, jVar);
                            if (!TextUtils.isEmpty(b2)) {
                                arrayList.add(new a(b2, str, null));
                            }
                        } catch (Exception e2) {
                            com.kwai.video.ksvodplayerkit.a.b.e("MultiRateSourceSwitcher", e2.getMessage());
                            return;
                        }
                    }
                    if (arrayList.size() > 0) {
                        g<a> gVar = new g<>();
                        jVar.f39894i = gVar;
                        gVar.a(arrayList);
                        a(jVar, jVar.f39894i.c());
                    } else {
                        com.kwai.video.ksvodplayerkit.a.b.e("HostSwitcher", "MultiRateSourceSwitcher. Init failed");
                    }
                }
            }
        }
    }

    private void a(j jVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, jVar, aVar) == null) {
            String str = aVar.f39826b;
            jVar.f39892g = str;
            jVar.f39887b = aVar.f39825a;
            jVar.f39888c = com.kwai.video.ksvodplayerkit.c.c.c(str);
        }
    }

    private void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, list) == null) {
            for (String str : list) {
                ArrayList arrayList = new ArrayList();
                String b2 = com.kwai.video.ksvodplayerkit.c.a.b(str);
                int i2 = 0;
                for (f fVar : e.a().a(b2)) {
                    arrayList.add(new a(b2, str, str.replace(b2, fVar.f39843b), fVar));
                    this.f39834d = true;
                    if (list.size() > 1 && (i2 = i2 + 1) >= 2) {
                        break;
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList.add(new a(b2, str, str, (f) null));
                }
                this.f39831a.a(arrayList);
            }
            if (com.kwai.video.ksvodplayerkit.i.a().j()) {
                Collections.sort(this.f39831a.f39847a);
            }
        }
    }

    private void b(String str) {
        c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            com.kwai.video.ksvodplayerkit.b.c a2 = com.kwai.video.ksvodplayerkit.b.d.a(str);
            this.f39839i = a2;
            if (a2 == null || (aVar = a2.f39866c) == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < aVar.f39868a.size(); i2++) {
                ArrayList<a> arrayList2 = new ArrayList();
                com.kwai.video.ksvodplayerkit.b.f fVar = aVar.f39868a.get(i2);
                String str2 = fVar.f39869a;
                try {
                    arrayList2.add(new a(com.kwai.video.ksvodplayerkit.c.a.b(str2), str2, str2, (f) null));
                    for (String str3 : fVar.f39870b) {
                        arrayList2.add(new a(com.kwai.video.ksvodplayerkit.c.a.b(str3), str3, str3, (f) null));
                    }
                    for (a aVar2 : arrayList2) {
                        for (f fVar2 : e.a().a(aVar2.f39825a)) {
                            this.f39834d = true;
                            String str4 = aVar2.f39825a;
                            a aVar3 = new a(str4, aVar2.f39829e.replace(str4, fVar2.f39843b), fVar2);
                            arrayList.add(aVar3);
                            this.j.put(aVar3.f39826b, fVar);
                        }
                        this.j.put(aVar2.f39829e, fVar);
                        if (!TextUtils.isEmpty(aVar2.f39825a)) {
                            arrayList.add(new a(aVar2.f39825a, aVar2.f39829e, null));
                        }
                    }
                    if (arrayList.size() > 0) {
                        g<a> gVar = new g<>();
                        fVar.n = gVar;
                        gVar.a(arrayList);
                        a(fVar, fVar.n.c(), null);
                    }
                } catch (Exception e2) {
                    com.kwai.video.ksvodplayerkit.a.b.e("initHlsAdaptationSet host parse failed", e2.getMessage());
                }
            }
        }
    }

    private g<a> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            int i2 = this.k;
            if (i2 == 1) {
                j jVar = this.f39836f.get(this.f39837g);
                if (jVar != null) {
                    return jVar.f39894i;
                }
                return null;
            } else if (i2 == 2) {
                com.kwai.video.ksvodplayerkit.b.f fVar = this.j.get(this.f39837g);
                if (fVar != null) {
                    return fVar.n;
                }
                return null;
            } else {
                return this.f39831a;
            }
        }
        return (g) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f39837g = str;
        }
    }

    public void a(boolean z) {
        h hVar;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f39834d) {
            return;
        }
        if (this.k == 0) {
            a(this.f39832b);
        }
        if (this.k == 2 && (str = this.f39833c) != null) {
            b(str);
        } else if (this.k != 1 || (hVar = this.f39838h) == null) {
        } else {
            a(hVar);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        String str;
        String str2;
        g<a> gVar;
        g<a> gVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.k == 1) {
                j jVar = this.f39836f.get(this.f39837g);
                if (jVar == null || (gVar2 = jVar.f39894i) == null) {
                    return false;
                }
                a b2 = b();
                String str3 = b2 != null ? b2.f39826b : null;
                if (!e()) {
                    jVar.f39894i.a();
                }
                a(jVar, jVar.f39894i.c());
                a c2 = gVar2.c();
                if ((c2 == null || TextUtils.equals(str3, c2.f39826b)) ? false : true) {
                    str2 = "URL_TYPE_MULTIRATE_MANIFEST switch PlayUrls";
                    com.kwai.video.ksvodplayerkit.a.b.b("HostSwitcher", str2);
                    return true;
                }
            }
            if (this.k != 2) {
                a b3 = b();
                str = b3 != null ? b3.f39826b : null;
                if (!e()) {
                    this.f39831a.a();
                }
                a b4 = b();
                if ((b4 == null || TextUtils.equals(str, b4.f39826b)) ? false : true) {
                    str2 = "switch PlayUrls";
                    com.kwai.video.ksvodplayerkit.a.b.b("HostSwitcher", str2);
                    return true;
                }
                com.kwai.video.ksvodplayerkit.a.b.d("HostSwitcher", "switchHost play url failed! url type:" + this.k);
                return false;
            }
            com.kwai.video.ksvodplayerkit.b.f fVar = this.j.get(this.f39837g);
            if (fVar == null || (gVar = fVar.n) == null) {
                return false;
            }
            a b5 = b();
            str = b5 != null ? b5.f39826b : null;
            if (!e()) {
                fVar.n.a();
            }
            a c3 = gVar.c();
            if ((c3 == null || TextUtils.equals(str, c3.f39826b)) ? false : true) {
                a(fVar, fVar.n.c(), b5);
                str2 = "URL_TYPE_HLS_MANIFEST switch PlayUrls";
                com.kwai.video.ksvodplayerkit.a.b.b("HostSwitcher", str2);
                return true;
            }
            com.kwai.video.ksvodplayerkit.a.b.d("HostSwitcher", "switchHost play url failed! url type:" + this.k);
            return false;
        }
        return invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            g<a> j = j();
            if (j == null || j.b() <= 0) {
                return null;
            }
            return j.c();
        }
        return (a) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            g<a> j = j();
            if (j != null) {
                return j.d();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            a b2 = b();
            return b2 != null ? b2.f39825a : "";
        }
        return (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g<a> j = j();
            return j != null && j.d() == j.b() - 1;
        }
        return invokeV.booleanValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            g<a> j = j();
            if (j != null) {
                return j.b();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public l g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39835e : (l) invokeV.objValue;
    }

    public com.kwai.video.ksvodplayerkit.b.c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f39839i : (com.kwai.video.ksvodplayerkit.b.c) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        String str;
        a b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.k;
            if ((i2 == 2 || i2 == 1) && (str = this.f39837g) != null) {
                return str;
            }
            if (this.k != 0 || (b2 = b()) == null) {
                return null;
            }
            return b2.f39826b;
        }
        return (String) invokeV.objValue;
    }
}
