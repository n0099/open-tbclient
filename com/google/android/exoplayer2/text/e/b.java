package com.google.android.exoplayer2.text.e;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
/* loaded from: classes6.dex */
final class b {
    private List<b> UB;
    public final boolean mBr;
    public final e mBs;
    public final String mBt;
    private final String[] mBu;
    private final HashMap<String, Integer> mBv;
    private final HashMap<String, Integer> mBw;
    public final long mtk;
    public final long mtl;
    public final String tag;
    public final String text;

    public static b PY(String str) {
        return new b(null, d.PZ(str), -9223372036854775807L, -9223372036854775807L, null, null, "");
    }

    public static b a(String str, long j, long j2, e eVar, String[] strArr, String str2) {
        return new b(str, null, j, j2, eVar, strArr, str2);
    }

    private b(String str, String str2, long j, long j2, e eVar, String[] strArr, String str3) {
        this.tag = str;
        this.text = str2;
        this.mBs = eVar;
        this.mBu = strArr;
        this.mBr = str2 != null;
        this.mtk = j;
        this.mtl = j2;
        this.mBt = (String) com.google.android.exoplayer2.util.a.checkNotNull(str3);
        this.mBv = new HashMap<>();
        this.mBw = new HashMap<>();
    }

    public boolean gy(long j) {
        return (this.mtk == -9223372036854775807L && this.mtl == -9223372036854775807L) || (this.mtk <= j && this.mtl == -9223372036854775807L) || ((this.mtk == -9223372036854775807L && j < this.mtl) || (this.mtk <= j && j < this.mtl));
    }

    public void a(b bVar) {
        if (this.UB == null) {
            this.UB = new ArrayList();
        }
        this.UB.add(bVar);
    }

    public b Lx(int i) {
        if (this.UB == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.UB.get(i);
    }

    public int getChildCount() {
        if (this.UB == null) {
            return 0;
        }
        return this.UB.size();
    }

    public long[] dyk() {
        int i = 0;
        TreeSet<Long> treeSet = new TreeSet<>();
        a(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = i2 + 1;
                jArr[i2] = it.next().longValue();
            } else {
                return jArr;
            }
        }
    }

    private void a(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.tag);
        if (z || equals) {
            if (this.mtk != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.mtk));
            }
            if (this.mtl != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.mtl));
            }
        }
        if (this.UB != null) {
            for (int i = 0; i < this.UB.size(); i++) {
                this.UB.get(i).a(treeSet, z || equals);
            }
        }
    }

    public List<com.google.android.exoplayer2.text.b> a(long j, Map<String, e> map, Map<String, c> map2) {
        TreeMap treeMap = new TreeMap();
        a(j, false, this.mBt, (Map<String, SpannableStringBuilder>) treeMap);
        b(map, treeMap);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            c cVar = map2.get(entry.getKey());
            arrayList.add(new com.google.android.exoplayer2.text.b(d((SpannableStringBuilder) entry.getValue()), null, cVar.myB, cVar.myC, cVar.myD, cVar.myE, Integer.MIN_VALUE, cVar.width));
        }
        return arrayList;
    }

    private void a(long j, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        this.mBv.clear();
        this.mBw.clear();
        String str2 = this.mBt;
        if ("".equals(str2)) {
            str2 = str;
        }
        if (this.mBr && z) {
            m(str2, map).append((CharSequence) this.text);
        } else if ("br".equals(this.tag) && z) {
            m(str2, map).append('\n');
        } else if (!"metadata".equals(this.tag) && gy(j)) {
            boolean equals = "p".equals(this.tag);
            for (Map.Entry<String, SpannableStringBuilder> entry : map.entrySet()) {
                this.mBv.put(entry.getKey(), Integer.valueOf(entry.getValue().length()));
            }
            for (int i = 0; i < getChildCount(); i++) {
                Lx(i).a(j, z || equals, str2, map);
            }
            if (equals) {
                d.e(m(str2, map));
            }
            for (Map.Entry<String, SpannableStringBuilder> entry2 : map.entrySet()) {
                this.mBw.put(entry2.getKey(), Integer.valueOf(entry2.getValue().length()));
            }
        }
    }

    private static SpannableStringBuilder m(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return map.get(str);
    }

    private void b(Map<String, e> map, Map<String, SpannableStringBuilder> map2) {
        for (Map.Entry<String, Integer> entry : this.mBw.entrySet()) {
            String key = entry.getKey();
            a(map, map2.get(key), this.mBv.containsKey(key) ? this.mBv.get(key).intValue() : 0, entry.getValue().intValue());
            for (int i = 0; i < getChildCount(); i++) {
                Lx(i).b(map, map2);
            }
        }
    }

    private void a(Map<String, e> map, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        e a;
        if (i != i2 && (a = d.a(this.mBs, this.mBu, map)) != null) {
            d.a(spannableStringBuilder, i, i2, a);
        }
    }

    private SpannableStringBuilder d(SpannableStringBuilder spannableStringBuilder) {
        int i;
        int length = spannableStringBuilder.length();
        int i2 = 0;
        while (i2 < length) {
            if (spannableStringBuilder.charAt(i2) == ' ') {
                int i3 = i2 + 1;
                while (i3 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i3) == ' ') {
                    i3++;
                }
                int i4 = i3 - (i2 + 1);
                if (i4 > 0) {
                    spannableStringBuilder.delete(i2, i2 + i4);
                    i = length - i4;
                    i2++;
                    length = i;
                }
            }
            i = length;
            i2++;
            length = i;
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        int i5 = length;
        for (int i6 = 0; i6 < i5 - 1; i6++) {
            if (spannableStringBuilder.charAt(i6) == '\n' && spannableStringBuilder.charAt(i6 + 1) == ' ') {
                spannableStringBuilder.delete(i6 + 1, i6 + 2);
                i5--;
            }
        }
        if (i5 > 0 && spannableStringBuilder.charAt(i5 - 1) == ' ') {
            spannableStringBuilder.delete(i5 - 1, i5);
            i5--;
        }
        for (int i7 = 0; i7 < i5 - 1; i7++) {
            if (spannableStringBuilder.charAt(i7) == ' ' && spannableStringBuilder.charAt(i7 + 1) == '\n') {
                spannableStringBuilder.delete(i7, i7 + 1);
                i5--;
            }
        }
        if (i5 > 0 && spannableStringBuilder.charAt(i5 - 1) == '\n') {
            spannableStringBuilder.delete(i5 - 1, i5);
        }
        return spannableStringBuilder;
    }
}
