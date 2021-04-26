package com.tencent.open.a;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class g implements Iterable<String> {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentLinkedQueue<String> f37201a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f37202b;

    public g() {
        this.f37201a = null;
        this.f37202b = null;
        this.f37201a = new ConcurrentLinkedQueue<>();
        this.f37202b = new AtomicInteger(0);
    }

    public int a(String str) {
        int length = str.length();
        this.f37201a.add(str);
        return this.f37202b.addAndGet(length);
    }

    public void b() {
        this.f37201a.clear();
        this.f37202b.set(0);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f37201a.iterator();
    }

    public void a(Writer writer, char[] cArr) throws IOException {
        if (writer == null || cArr == null || cArr.length == 0) {
            return;
        }
        int length = cArr.length;
        Iterator<String> it = iterator();
        int i2 = length;
        int i3 = 0;
        while (it.hasNext()) {
            String next = it.next();
            int length2 = next.length();
            int i4 = 0;
            while (length2 > 0) {
                int i5 = i2 > length2 ? length2 : i2;
                int i6 = i4 + i5;
                next.getChars(i4, i6, cArr, i3);
                i2 -= i5;
                i3 += i5;
                length2 -= i5;
                if (i2 == 0) {
                    writer.write(cArr, 0, length);
                    i2 = length;
                    i4 = i6;
                    i3 = 0;
                } else {
                    i4 = i6;
                }
            }
        }
        if (i3 > 0) {
            writer.write(cArr, 0, i3);
        }
        writer.flush();
    }

    public int a() {
        return this.f37202b.get();
    }
}
