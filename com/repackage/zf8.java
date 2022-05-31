package com.repackage;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class zf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? ji.H() ? TbadkCoreApplication.getInst().getAutoPlaySwitch() != 3 : dg5.a().i() && ji.x() && TbadkCoreApplication.getInst().getAutoPlaySwitch() == 2 : invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            kv4 adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense != null && adAdSense.f())) {
                return ji.H();
            } else if (ji.x() && TbadkCoreApplication.getInst().getAutoPlaySwitch() == 2) {
                return true;
            } else {
                return ji.H() && TbadkCoreApplication.getInst().getAutoPlaySwitch() != 3;
            }
        }
        return invokeV.booleanValue;
    }

    public static int c(TbPageContext tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbPageContext, str)) == null) {
            if (tbPageContext == null || TextUtils.isEmpty(str)) {
                return 0;
            }
            if (!str.startsWith("tieba://deeplink?")) {
                return d(tbPageContext, str) ? 3 : 0;
            }
            Uri parse = Uri.parse(str);
            if (r78.j(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT))) != 1000) {
                return d(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
            }
            return 1;
        }
        return invokeLL.intValue;
    }

    public static boolean d(TbPageContext tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, tbPageContext, str)) == null) {
            String[] strArr = {str};
            if (UrlManager.getInstance().UrlValidated(str)) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) tbPageContext, strArr, true);
                return true;
            }
            return UrlManager.getInstance().dealOneLink(tbPageContext, strArr);
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(List<Object> list, int i) {
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, list, i) == null) || list == null || list.size() == 0) {
            return;
        }
        boolean z2 = MessageManager.getInstance().findTask(2016447) != null;
        int i3 = 0;
        while (i3 < list.size()) {
            if (list.get(i3) instanceof ICardInfo) {
                if (z2) {
                    ICardInfo iCardInfo = (ICardInfo) list.get(i3);
                    int viewCount = iCardInfo.getViewCount();
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < viewCount; i4++) {
                        ICardInfo viewItem = iCardInfo.getViewItem(i4, i);
                        if (viewItem != null) {
                            viewItem.setBdUniqueId(ta7.b.get(viewItem.getCardType()));
                            arrayList.add(viewItem);
                        }
                    }
                    if (arrayList.size() != 0) {
                        list.remove(i3);
                        list.addAll(i3, arrayList);
                        i2 = arrayList.size();
                        z = false;
                        if (!z) {
                            list.remove(i3);
                            i2 = 0;
                        }
                    }
                }
                i2 = 1;
                z = true;
                if (!z) {
                }
            } else {
                i2 = 1;
            }
            i3 += i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(List<jn> list, int i) {
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, list, i) == null) || list == null || list.size() == 0) {
            return;
        }
        boolean z2 = MessageManager.getInstance().findTask(2016447) != null;
        int i3 = 0;
        while (i3 < list.size()) {
            if (list.get(i3) instanceof eo4) {
                if (z2) {
                    if (!((eo4) list.get(i3)).isValid()) {
                        ((eo4) list.get(i3)).g();
                    }
                    if (((eo4) list.get(i3)).isValid()) {
                        ICardInfo e = ((eo4) list.get(i3)).e();
                        int viewCount = e.getViewCount();
                        ArrayList arrayList = new ArrayList();
                        for (int i4 = 0; i4 < viewCount; i4++) {
                            ICardInfo viewItem = e.getViewItem(i4, i);
                            if (viewItem != null) {
                                viewItem.setBdUniqueId(ta7.b.get(viewItem.getCardType()));
                                arrayList.add(viewItem);
                            }
                        }
                        if (arrayList.size() != 0) {
                            list.remove(i3);
                            list.addAll(i3, arrayList);
                            i2 = arrayList.size();
                            z = false;
                            if (!z) {
                                list.remove(i3);
                                i2 = 0;
                            }
                        }
                    }
                }
                i2 = 1;
                z = true;
                if (!z) {
                }
            } else {
                i2 = 1;
            }
            i3 += i2;
        }
    }

    public static ArrayList<BdUniqueId> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            int size = ta7.b.size();
            ArrayList<BdUniqueId> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                arrayList.add(ta7.b.valueAt(i));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
