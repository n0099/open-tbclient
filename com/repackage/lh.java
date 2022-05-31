package com.repackage;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.upload.BdUploadingLogInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class lh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<dh> a(ah ahVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ahVar)) == null) {
            ArrayList arrayList = new ArrayList();
            File[] b = ch.b(ahVar.C());
            if (b != null) {
                for (File file : b) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith(ahVar.h()) && name.contains("Uploading")) {
                            arrayList.add(new dh(name, file.length(), file.lastModified()));
                        }
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<dh> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                dh dhVar = (dh) it.next();
                if (dhVar != null) {
                    long j = dhVar.c;
                    if (j != 0 && j + 604800000 < currentTimeMillis) {
                        arrayList3.add(dhVar.b);
                    } else {
                        arrayList2.add(dhVar);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                ch.a(arrayList3, ahVar.C());
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static BdUploadingLogInfo b(ah ahVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ahVar)) == null) {
            ArrayList<dh> a = a(ahVar);
            BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(BdStatisticsManager.getInstance().getTrackLogWriteDir(), ahVar.C(), ahVar.A());
            if (a != null && a.size() > 0) {
                if (a.size() > 1) {
                    Collections.sort(a, new eh());
                }
                ArrayList arrayList = new ArrayList();
                int size = a.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    dh dhVar = a.get(i);
                    j += dhVar.a;
                    arrayList.add(dhVar);
                    if (j >= 20480) {
                        bdUploadingLogInfo.add(arrayList);
                        arrayList = new ArrayList();
                        j = 0;
                    }
                }
                if (arrayList.size() > 0) {
                    bdUploadingLogInfo.add(arrayList);
                }
            }
            return bdUploadingLogInfo;
        }
        return (BdUploadingLogInfo) invokeL.objValue;
    }
}
