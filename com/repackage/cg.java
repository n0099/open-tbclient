package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class cg {
    public static /* synthetic */ Interceptable $ic;
    public static String d;
    public static String e;
    public static String f;
    public static boolean g;
    public static String h;
    public static String i;
    public static String j;
    public static String k;
    public transient /* synthetic */ FieldHolder $fh;
    public sf a;
    public pf b;
    public long c;

    public cg() {
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
        i();
    }

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            d = str;
        }
    }

    public static void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            h = str;
        }
    }

    public static void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            i = str;
        }
    }

    public static void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            j = str;
        }
    }

    public static void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            k = str;
        }
    }

    public static void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, null, z) == null) {
            g = z;
        }
    }

    public static void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            f = str;
        }
    }

    public static void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            e = str;
        }
    }

    public final void a(sf sfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sfVar) == null) {
            b(sfVar, false);
        }
    }

    public final void b(sf sfVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sfVar, z) == null) || sfVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(d)) {
            sfVar.b().a("Cookie", d);
        } else {
            sfVar.b().a("Cookie", "");
        }
        if (!TextUtils.isEmpty(f)) {
            sfVar.b().a("client_user_token", f);
        }
        if (!TextUtils.isEmpty(e)) {
            sfVar.b().a("User-Agent", e);
        }
        if (z) {
            sfVar.b().a("Accept-Encoding", "gzip");
        } else {
            sfVar.b().a("Accept-Encoding", "");
        }
        if (g) {
            sfVar.b().a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            sfVar.b().a(HTTP.CONN_DIRECTIVE, "close");
        }
        sfVar.b().a("client_logid", String.valueOf(this.c));
        if (!TextUtils.isEmpty(h)) {
            sfVar.b().a("cuid", h);
        }
        if (!TextUtils.isEmpty(i)) {
            sfVar.b().a("cuid_galaxy2", i);
        }
        if (!TextUtils.isEmpty(j)) {
            sfVar.b().a("c3_aid", j);
        }
        if (TextUtils.isEmpty(k)) {
            return;
        }
        sfVar.b().a(TiebaStatic.Params.CUID_GID, k);
    }

    public void c() {
        pf pfVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (pfVar = this.b) == null) {
            return;
        }
        pfVar.b();
    }

    public boolean d(String str, String str2, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList, wf wfVar, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), linkedList, wfVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            sf sfVar = new sf();
            this.a = sfVar;
            a(sfVar);
            this.a.b().s(str);
            this.a.b().o(z4);
            pf pfVar = new pf(this.a);
            this.b = pfVar;
            return pfVar.c(str2, wfVar, i2, i3, i4, i5, z2, z3);
        }
        return invokeCommon.booleanValue;
    }

    public sf e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (sf) invokeV.objValue;
    }

    public pf f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (pf) invokeV.objValue;
    }

    public uf g(String str, int i2, int i3, int i4) throws Exception {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048582, this, str, i2, i3, i4)) == null) ? h(str, false, i2, i3, i4) : (uf) invokeLIII.objValue;
    }

    public uf h(String str, boolean z, int i2, int i3, int i4) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            sf sfVar = new sf();
            this.a = sfVar;
            b(sfVar, z);
            this.a.b().s(str);
            pf pfVar = new pf(this.a);
            this.b = pfVar;
            pfVar.d(i2, i3, i4);
            return this.a.c();
        }
        return (uf) invokeCommon.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            System.setProperty("http.keepAlive", "false");
            this.c = BdStatisticsManager.getInstance().getClientLogId();
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            pf pfVar = this.b;
            if (pfVar != null) {
                return pfVar.k();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public uf k(String str, List<BasicNameValuePair> list, boolean z, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, list, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), linkedList})) == null) {
            sf sfVar = new sf();
            this.a = sfVar;
            b(sfVar, z);
            this.a.b().s(str);
            if (list != null) {
                for (BasicNameValuePair basicNameValuePair : list) {
                    this.a.b().d(basicNameValuePair);
                }
            }
            if (linkedList != null) {
                Iterator<BasicNameValuePair> it = linkedList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    this.a.b().a(next.getName(), next.getValue());
                }
            }
            pf pfVar = new pf(this.a);
            this.b = pfVar;
            pfVar.m(i2, i3, -1);
            return this.a.c();
        }
        return (uf) invokeCommon.objValue;
    }

    public uf l(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), arrayList, hashMap, Integer.valueOf(i2), Integer.valueOf(i3), linkedList})) == null) {
            sf sfVar = new sf();
            this.a = sfVar;
            b(sfVar, z);
            this.a.b().s(str);
            if (linkedList != null) {
                Iterator<BasicNameValuePair> it = linkedList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    this.a.b().a(next.getName(), next.getValue());
                }
            }
            if (arrayList != null) {
                Iterator<BasicNameValuePair> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    BasicNameValuePair next2 = it2.next();
                    this.a.b().b(next2.getName(), next2.getValue());
                }
            }
            if (hashMap != null) {
                for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                    this.a.b().c(entry.getKey(), entry.getValue());
                }
            }
            pf pfVar = new pf(this.a);
            this.b = pfVar;
            pfVar.m(i2, i3, -1);
            return this.a.c();
        }
        return (uf) invokeCommon.objValue;
    }

    public void m() {
        pf pfVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (pfVar = this.b) == null) {
            return;
        }
        pfVar.p();
    }
}
