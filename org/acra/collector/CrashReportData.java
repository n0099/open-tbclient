package org.acra.collector;

import java.util.EnumMap;
import org.acra.ReportField;
/* loaded from: classes.dex */
public final class CrashReportData extends EnumMap {
    private static final long serialVersionUID = 4112578634029874840L;

    public CrashReportData() {
        super(ReportField.class);
    }

    public String getProperty(ReportField reportField) {
        return (String) super.get(reportField);
    }
}
