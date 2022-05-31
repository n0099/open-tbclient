package com.repackage;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.upload.BdUploadingLogInfo;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class jh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<dh> a(ah ahVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65536, null, ahVar, z)) == null) {
            ArrayList<dh> arrayList = new ArrayList<>();
            File[] b = bh.b(ahVar.E(), z);
            if (b != null) {
                for (File file : b) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith(ahVar.h()) && name.contains("Uploading")) {
                            long length = file.length();
                            if (z && file.getPath().contains("/notUpload")) {
                                name = "notUpload/" + file.getName();
                            }
                            arrayList.add(new dh(name, length, file.lastModified()));
                        }
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<dh> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            if (ahVar.h() != "stat") {
                Iterator<dh> it = arrayList.iterator();
                while (it.hasNext()) {
                    dh next = it.next();
                    if (next != null) {
                        long j = next.c;
                        if (j != 0 && j + 604800000 < currentTimeMillis) {
                            arrayList3.add(next.b);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                arrayList = arrayList2;
            }
            if (arrayList3.size() > 0) {
                bh.a(arrayList3, ahVar.E());
            }
            return arrayList;
        }
        return (ArrayList) invokeLZ.objValue;
    }

    public static BdUploadingLogInfo b(ah ahVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, ahVar, z)) == null) {
            ArrayList<dh> a = a(ahVar, z);
            BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(BdStatisticsManager.getInstance().getWriteDir(), ahVar.E(), ahVar.A());
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
                    if (j >= ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
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
        return (BdUploadingLogInfo) invokeLZ.objValue;
    }
}
