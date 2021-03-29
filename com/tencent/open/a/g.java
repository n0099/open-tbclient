package com.tencent.open.a;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class g implements Iterable<String> {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentLinkedQueue<String> f39216a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f39217b;

    public g() {
        this.f39216a = null;
        this.f39217b = null;
        this.f39216a = new ConcurrentLinkedQueue<>();
        this.f39217b = new AtomicInteger(0);
    }

    public int a(String str) {
        int length = str.length();
        this.f39216a.add(str);
        return this.f39217b.addAndGet(length);
    }

    public void b() {
        this.f39216a.clear();
        this.f39217b.set(0);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f39216a.iterator();
    }

    public void a(Writer writer, char[] cArr) throws IOException {
        if (writer == null || cArr == null || cArr.length == 0) {
            return;
        }
        int length = cArr.length;
        Iterator<String> it = iterator();
        int i = length;
        int i2 = 0;
        while (it.hasNext()) {
            String next = it.next();
            int length2 = next.length();
            int i3 = 0;
            while (length2 > 0) {
                int i4 = i > length2 ? length2 : i;
                int i5 = i3 + i4;
                next.getChars(i3, i5, cArr, i2);
                i -= i4;
                i2 += i4;
                length2 -= i4;
                if (i == 0) {
                    writer.write(cArr, 0, length);
                    i = length;
                    i3 = i5;
                    i2 = 0;
                } else {
                    i3 = i5;
                }
            }
        }
        if (i2 > 0) {
            writer.write(cArr, 0, i2);
        }
        writer.flush();
    }

    public int a() {
        return this.f39217b.get();
    }
}
