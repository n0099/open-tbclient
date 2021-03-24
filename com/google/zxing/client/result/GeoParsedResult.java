package com.google.zxing.client.result;

import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes6.dex */
public final class GeoParsedResult extends ParsedResult {
    public final double altitude;
    public final double latitude;
    public final double longitude;
    public final String query;

    public GeoParsedResult(double d2, double d3, double d4, String str) {
        super(ParsedResultType.GEO);
        this.latitude = d2;
        this.longitude = d3;
        this.altitude = d4;
        this.query = str;
    }

    public double getAltitude() {
        return this.altitude;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.latitude);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append(this.longitude);
        if (this.altitude > 0.0d) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.altitude);
            sb.append('m');
        }
        if (this.query != null) {
            sb.append(" (");
            sb.append(this.query);
            sb.append(')');
        }
        return sb.toString();
    }

    public String getGeoURI() {
        StringBuilder sb = new StringBuilder();
        sb.append("geo:");
        sb.append(this.latitude);
        sb.append(',');
        sb.append(this.longitude);
        if (this.altitude > 0.0d) {
            sb.append(',');
            sb.append(this.altitude);
        }
        if (this.query != null) {
            sb.append('?');
            sb.append(this.query);
        }
        return sb.toString();
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getQuery() {
        return this.query;
    }
}
