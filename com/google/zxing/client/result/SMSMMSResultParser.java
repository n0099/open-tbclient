package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes3.dex */
public final class SMSMMSResultParser extends ResultParser {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public SMSParsedResult parse(Result result) {
        String str;
        String str2;
        String substring;
        String massagedText = getMassagedText(result);
        if (!massagedText.startsWith("sms:") && !massagedText.startsWith("SMS:") && !massagedText.startsWith("mms:") && !massagedText.startsWith("MMS:")) {
            return null;
        }
        Map<String, String> parseNameValuePairs = parseNameValuePairs(massagedText);
        boolean z = false;
        if (parseNameValuePairs == null || parseNameValuePairs.isEmpty()) {
            str = null;
            str2 = null;
        } else {
            str = parseNameValuePairs.get("body");
            str2 = parseNameValuePairs.get("subject");
            z = true;
        }
        int indexOf = massagedText.indexOf(63, 4);
        if (indexOf < 0 || !z) {
            substring = massagedText.substring(4);
        } else {
            substring = massagedText.substring(4, indexOf);
        }
        int i = -1;
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        while (true) {
            int indexOf2 = substring.indexOf(44, i + 1);
            if (indexOf2 > i) {
                addNumberVia(arrayList, arrayList2, substring.substring(i + 1, indexOf2));
                i = indexOf2;
            } else {
                addNumberVia(arrayList, arrayList2, substring.substring(i + 1));
                return new SMSParsedResult((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), str2, str);
            }
        }
    }

    private static void addNumberVia(Collection<String> collection, Collection<String> collection2, String str) {
        int indexOf = str.indexOf(59);
        if (indexOf < 0) {
            collection.add(str);
            collection2.add(null);
            return;
        }
        collection.add(str.substring(0, indexOf));
        String substring = str.substring(indexOf + 1);
        collection2.add(substring.startsWith("via=") ? substring.substring(4) : null);
    }
}
