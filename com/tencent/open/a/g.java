package com.tencent.open.a;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class g implements Iterable<String> {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentLinkedQueue<String> f13680a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicInteger f13681b;

    public g() {
        this.f13680a = null;
        this.f13681b = null;
        this.f13680a = new ConcurrentLinkedQueue<>();
        this.f13681b = new AtomicInteger(0);
    }

    public int a(String str) {
        int length = str.length();
        this.f13680a.add(str);
        return this.f13681b.addAndGet(length);
    }

    public void a(Writer writer, char[] cArr) throws IOException {
        if (writer != null && cArr != null && cArr.length != 0) {
            int length = cArr.length;
            Iterator<String> it = iterator();
            int i = 0;
            int i2 = length;
            while (it.hasNext()) {
                String next = it.next();
                int length2 = next.length();
                int i3 = 0;
                while (length2 > 0) {
                    int i4 = i2 > length2 ? length2 : i2;
                    next.getChars(i3, i3 + i4, cArr, i);
                    i2 -= i4;
                    i += i4;
                    length2 -= i4;
                    int i5 = i4 + i3;
                    if (i2 == 0) {
                        writer.write(cArr, 0, length);
                        i = 0;
                        i2 = length;
                        i3 = i5;
                    } else {
                        i3 = i5;
                    }
                }
            }
            if (i > 0) {
                writer.write(cArr, 0, i);
            }
            writer.flush();
        }
    }

    public int a() {
        return this.f13681b.get();
    }

    public void b() {
        this.f13680a.clear();
        this.f13681b.set(0);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f13680a.iterator();
    }
}
