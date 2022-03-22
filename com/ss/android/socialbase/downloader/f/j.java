package com.ss.android.socialbase.downloader.f;

import com.baidu.android.common.others.lang.StringUtil;
import com.ss.android.socialbase.downloader.exception.BaseException;
/* loaded from: classes7.dex */
public class j extends BaseException {
    public int a;

    public j(int i, String str) {
        super(1072, "applyCode=" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + str);
        this.a = i;
    }
}
