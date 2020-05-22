package com.qiniu.android.bigdata.pipeline;

import com.qiniu.android.utils.FastDatePrinter;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes5.dex */
public final class Points {

    /* loaded from: classes5.dex */
    private static class LazyHolder {
        private static final FastDatePrinter nfj = new FastDatePrinter("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Calendar.getInstance().getTimeZone(), Locale.getDefault());

        private LazyHolder() {
        }
    }
}
