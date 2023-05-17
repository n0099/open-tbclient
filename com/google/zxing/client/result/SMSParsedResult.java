package com.google.zxing.client.result;

import com.baidu.tbadk.core.util.UrlSchemaHelper;
import org.apache.commons.codec.net.RFC1522Codec;
/* loaded from: classes9.dex */
public final class SMSParsedResult extends ParsedResult {
    public final String body;
    public final String[] numbers;
    public final String subject;
    public final String[] vias;

    public SMSParsedResult(String str, String str2, String str3, String str4) {
        super(ParsedResultType.SMS);
        this.numbers = new String[]{str};
        this.vias = new String[]{str2};
        this.subject = str3;
        this.body = str4;
    }

    public SMSParsedResult(String[] strArr, String[] strArr2, String str, String str2) {
        super(ParsedResultType.SMS);
        this.numbers = strArr;
        this.vias = strArr2;
        this.subject = str;
        this.body = str2;
    }

    public String getBody() {
        return this.body;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(100);
        ParsedResult.maybeAppend(this.numbers, sb);
        ParsedResult.maybeAppend(this.subject, sb);
        ParsedResult.maybeAppend(this.body, sb);
        return sb.toString();
    }

    public String[] getNumbers() {
        return this.numbers;
    }

    public String getSubject() {
        return this.subject;
    }

    public String[] getVias() {
        return this.vias;
    }

    public String getSMSURI() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_SMS);
        boolean z2 = false;
        boolean z3 = true;
        for (int i = 0; i < this.numbers.length; i++) {
            if (z3) {
                z3 = false;
            } else {
                sb.append(',');
            }
            sb.append(this.numbers[i]);
            String[] strArr = this.vias;
            if (strArr != null && strArr[i] != null) {
                sb.append(";via=");
                sb.append(this.vias[i]);
            }
        }
        if (this.body != null) {
            z = true;
        } else {
            z = false;
        }
        if (this.subject != null) {
            z2 = true;
        }
        if (z || z2) {
            sb.append(RFC1522Codec.SEP);
            if (z) {
                sb.append("body=");
                sb.append(this.body);
            }
            if (z2) {
                if (z) {
                    sb.append('&');
                }
                sb.append("subject=");
                sb.append(this.subject);
            }
        }
        return sb.toString();
    }
}
