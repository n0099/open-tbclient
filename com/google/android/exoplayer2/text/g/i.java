package com.google.android.exoplayer2.text.g;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.util.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
final class i implements com.google.android.exoplayer2.text.e {
    private final long[] mBf;
    private final int mCr;
    private final long[] mCs;
    private final List<e> mzg;

    public i(List<e> list) {
        this.mzg = list;
        this.mCr = list.size();
        this.mBf = new long[this.mCr * 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mCr) {
                e eVar = list.get(i2);
                int i3 = i2 * 2;
                this.mBf[i3] = eVar.startTime;
                this.mBf[i3 + 1] = eVar.endTime;
                i = i2 + 1;
            } else {
                this.mCs = Arrays.copyOf(this.mBf, this.mBf.length);
                Arrays.sort(this.mCs);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gw(long j) {
        int b = v.b(this.mCs, j, false, false);
        if (b < this.mCs.length) {
            return b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dxK() {
        return this.mCs.length;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lk(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i >= 0);
        com.google.android.exoplayer2.util.a.checkArgument(i < this.mCs.length);
        return this.mCs[i];
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gx(long j) {
        e eVar;
        ArrayList arrayList;
        SpannableStringBuilder spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2 = null;
        int i = 0;
        e eVar2 = null;
        ArrayList arrayList2 = null;
        while (i < this.mCr) {
            if (this.mBf[i * 2] > j || j >= this.mBf[(i * 2) + 1]) {
                SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder2;
                eVar = eVar2;
                arrayList = arrayList2;
                spannableStringBuilder = spannableStringBuilder3;
            } else {
                ArrayList arrayList3 = arrayList2 == null ? new ArrayList() : arrayList2;
                e eVar3 = this.mzg.get(i);
                if (eVar3.dyt()) {
                    if (eVar2 == null) {
                        arrayList = arrayList3;
                        spannableStringBuilder = spannableStringBuilder2;
                        eVar = eVar3;
                    } else if (spannableStringBuilder2 == null) {
                        SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder();
                        spannableStringBuilder4.append(eVar2.text).append((CharSequence) "\n").append(eVar3.text);
                        spannableStringBuilder = spannableStringBuilder4;
                        eVar = eVar2;
                        arrayList = arrayList3;
                    } else {
                        spannableStringBuilder2.append((CharSequence) "\n").append(eVar3.text);
                        spannableStringBuilder = spannableStringBuilder2;
                        eVar = eVar2;
                        arrayList = arrayList3;
                    }
                } else {
                    arrayList3.add(eVar3);
                    spannableStringBuilder = spannableStringBuilder2;
                    eVar = eVar2;
                    arrayList = arrayList3;
                }
            }
            i++;
            SpannableStringBuilder spannableStringBuilder5 = spannableStringBuilder;
            arrayList2 = arrayList;
            eVar2 = eVar;
            spannableStringBuilder2 = spannableStringBuilder5;
        }
        if (spannableStringBuilder2 != null) {
            arrayList2.add(new e(spannableStringBuilder2));
        } else if (eVar2 != null) {
            arrayList2.add(eVar2);
        }
        return arrayList2 != null ? arrayList2 : Collections.emptyList();
    }
}
