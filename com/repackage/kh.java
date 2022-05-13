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
public class kh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<eh> a(bh bhVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65536, null, bhVar, z)) == null) {
            ArrayList<eh> arrayList = new ArrayList<>();
            File[] b = ch.b(bhVar.E(), z);
            if (b != null) {
                for (File file : b) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith(bhVar.h()) && name.contains("Uploading")) {
                            long length = file.length();
                            if (z && file.getPath().contains("/notUpload")) {
                                name = "notUpload/" + file.getName();
                            }
                            arrayList.add(new eh(name, length, file.lastModified()));
                        }
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<eh> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            if (bhVar.h() != "stat") {
                Iterator<eh> it = arrayList.iterator();
                while (it.hasNext()) {
                    eh next = it.next();
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
                ch.a(arrayList3, bhVar.E());
            }
            return arrayList;
        }
        return (ArrayList) invokeLZ.objValue;
    }

    public static BdUploadingLogInfo b(bh bhVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, bhVar, z)) == null) {
            ArrayList<eh> a = a(bhVar, z);
            BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(BdStatisticsManager.getInstance().getWriteDir(), bhVar.E(), bhVar.A());
            if (a != null && a.size() > 0) {
                if (a.size() > 1) {
                    Collections.sort(a, new fh());
                }
                ArrayList arrayList = new ArrayList();
                int size = a.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    eh ehVar = a.get(i);
                    j += ehVar.a;
                    arrayList.add(ehVar);
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
