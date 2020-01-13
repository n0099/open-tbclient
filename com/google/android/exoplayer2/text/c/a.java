package com.google.android.exoplayer2.text.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class a extends c {
    private static final Pattern mAl = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    private final boolean mAm;
    private int mAn;
    private int mAo;
    private int mAp;
    private int mAq;

    public a() {
        this(null);
    }

    public a(List<byte[]> list) {
        super("SsaDecoder");
        if (list != null && !list.isEmpty()) {
            this.mAm = true;
            String str = new String(list.get(0));
            com.google.android.exoplayer2.util.a.checkArgument(str.startsWith("Format: "));
            PH(str);
            U(new l(list.get(1)));
            return;
        }
        this.mAm = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.c
    /* renamed from: d */
    public b b(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        g gVar = new g();
        l lVar = new l(bArr, i);
        if (!this.mAm) {
            U(lVar);
        }
        a(lVar, arrayList, gVar);
        com.google.android.exoplayer2.text.b[] bVarArr = new com.google.android.exoplayer2.text.b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return new b(bVarArr, gVar.dya());
    }

    private void U(l lVar) {
        String readLine;
        do {
            readLine = lVar.readLine();
            if (readLine == null) {
                return;
            }
        } while (!readLine.startsWith("[Events]"));
    }

    private void a(l lVar, List<com.google.android.exoplayer2.text.b> list, g gVar) {
        while (true) {
            String readLine = lVar.readLine();
            if (readLine != null) {
                if (!this.mAm && readLine.startsWith("Format: ")) {
                    PH(readLine);
                } else if (readLine.startsWith("Dialogue: ")) {
                    a(readLine, list, gVar);
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void PH(String str) {
        char c;
        String[] split = TextUtils.split(str.substring("Format: ".length()), Constants.ACCEPT_TIME_SEPARATOR_SP);
        this.mAn = split.length;
        this.mAo = -1;
        this.mAp = -1;
        this.mAq = -1;
        for (int i = 0; i < this.mAn; i++) {
            String Qo = v.Qo(split[i].trim());
            switch (Qo.hashCode()) {
                case 100571:
                    if (Qo.equals("end")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 3556653:
                    if (Qo.equals("text")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 109757538:
                    if (Qo.equals("start")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    this.mAo = i;
                    break;
                case 1:
                    this.mAp = i;
                    break;
                case 2:
                    this.mAq = i;
                    break;
            }
        }
    }

    private void a(String str, List<com.google.android.exoplayer2.text.b> list, g gVar) {
        long j;
        if (this.mAn == 0) {
            Log.w("SsaDecoder", "Skipping dialogue line before format: " + str);
            return;
        }
        String[] split = str.substring("Dialogue: ".length()).split(Constants.ACCEPT_TIME_SEPARATOR_SP, this.mAn);
        long PI = PI(split[this.mAo]);
        if (PI == -9223372036854775807L) {
            Log.w("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        String str2 = split[this.mAp];
        if (str2.trim().isEmpty()) {
            j = -9223372036854775807L;
        } else {
            j = PI(str2);
            if (j == -9223372036854775807L) {
                Log.w("SsaDecoder", "Skipping invalid timing: " + str);
                return;
            }
        }
        list.add(new com.google.android.exoplayer2.text.b(split[this.mAq].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
        gVar.gI(PI);
        if (j != -9223372036854775807L) {
            list.add(null);
            gVar.gI(j);
        }
    }

    public static long PI(String str) {
        Matcher matcher = mAl.matcher(str);
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(1)) * 60 * 60 * TimeUtils.NANOS_PER_MS) + (Long.parseLong(matcher.group(2)) * 60 * TimeUtils.NANOS_PER_MS) + (Long.parseLong(matcher.group(3)) * TimeUtils.NANOS_PER_MS);
    }
}
