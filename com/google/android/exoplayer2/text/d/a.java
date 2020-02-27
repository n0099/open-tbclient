package com.google.android.exoplayer2.text.d;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.l;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class a extends c {
    private static final Pattern mBe = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    private final StringBuilder mBf;

    public a() {
        super("SubripDecoder");
        this.mBf = new StringBuilder();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.c
    /* renamed from: e */
    public b b(byte[] bArr, int i, boolean z) {
        boolean z2;
        ArrayList arrayList = new ArrayList();
        g gVar = new g();
        l lVar = new l(bArr, i);
        while (true) {
            String readLine = lVar.readLine();
            if (readLine == null) {
                break;
            } else if (readLine.length() != 0) {
                try {
                    Integer.parseInt(readLine);
                    String readLine2 = lVar.readLine();
                    if (readLine2 == null) {
                        Log.w("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = mBe.matcher(readLine2);
                    if (matcher.matches()) {
                        gVar.gG(a(matcher, 1));
                        if (TextUtils.isEmpty(matcher.group(6))) {
                            z2 = false;
                        } else {
                            gVar.gG(a(matcher, 6));
                            z2 = true;
                        }
                        this.mBf.setLength(0);
                        while (true) {
                            String readLine3 = lVar.readLine();
                            if (TextUtils.isEmpty(readLine3)) {
                                break;
                            }
                            if (this.mBf.length() > 0) {
                                this.mBf.append("<br>");
                            }
                            this.mBf.append(readLine3.trim());
                        }
                        arrayList.add(new com.google.android.exoplayer2.text.b(Html.fromHtml(this.mBf.toString())));
                        if (z2) {
                            arrayList.add(null);
                        }
                    } else {
                        Log.w("SubripDecoder", "Skipping invalid timing: " + readLine2);
                    }
                } catch (NumberFormatException e) {
                    Log.w("SubripDecoder", "Skipping invalid index: " + readLine);
                }
            }
        }
        com.google.android.exoplayer2.text.b[] bVarArr = new com.google.android.exoplayer2.text.b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return new b(bVarArr, gVar.dzm());
    }

    private static long a(Matcher matcher, int i) {
        return ((Long.parseLong(matcher.group(i + 1)) * 60 * 60 * 1000) + (Long.parseLong(matcher.group(i + 2)) * 60 * 1000) + (Long.parseLong(matcher.group(i + 3)) * 1000) + Long.parseLong(matcher.group(i + 4))) * 1000;
    }
}
