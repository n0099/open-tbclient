package org.msgpack.io;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public class LinkedBufferInput extends a {
    private int c;
    private final int f;

    /* renamed from: a  reason: collision with root package name */
    LinkedList<ByteBuffer> f3056a = new LinkedList<>();
    int b = -1;
    private byte[] d = new byte[8];
    private ByteBuffer e = ByteBuffer.wrap(this.d);

    public LinkedBufferInput(int i) {
        this.f = i;
    }

    @Override // org.msgpack.io.e
    public int a(byte[] bArr, int i, int i2) {
        ByteBuffer first;
        if (this.f3056a.isEmpty()) {
            return 0;
        }
        int i3 = i2;
        do {
            first = this.f3056a.getFirst();
            if (i3 < first.remaining()) {
                first.get(bArr, i, i3);
                a(i3);
                return i2;
            }
            int remaining = first.remaining();
            first.get(bArr, i, remaining);
            a(remaining);
            i3 -= remaining;
            i += remaining;
        } while (a(first));
        return i2 - i3;
    }

    @Override // org.msgpack.io.e
    public boolean a(b bVar, int i) {
        ByteBuffer byteBuffer = null;
        try {
            byteBuffer = this.f3056a.getFirst();
        } catch (NoSuchElementException e) {
        }
        if (byteBuffer == null) {
            throw new EndOfBufferException();
        }
        if (byteBuffer.remaining() < i) {
            return false;
        }
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        try {
            byteBuffer.limit(position + i);
            bVar.a(byteBuffer, true);
            a(i);
            byteBuffer.limit(limit);
            byteBuffer.position(position + i);
            if (byteBuffer.remaining() == 0) {
                a(byteBuffer);
            }
            return true;
        } catch (Throwable th) {
            byteBuffer.limit(limit);
            byteBuffer.position(position);
            if (byteBuffer.remaining() == 0) {
                a(byteBuffer);
            }
            throw th;
        }
    }

    @Override // org.msgpack.io.e
    public byte b() {
        ByteBuffer byteBuffer;
        try {
            byteBuffer = this.f3056a.getFirst();
        } catch (NoSuchElementException e) {
            byteBuffer = null;
        }
        if (byteBuffer == null || byteBuffer.remaining() == 0) {
            throw new EndOfBufferException();
        }
        byte b = byteBuffer.get();
        a();
        if (byteBuffer.remaining() == 0) {
            a(byteBuffer);
        }
        return b;
    }

    @Override // org.msgpack.io.e
    public void c() {
        if (!this.f3056a.isEmpty()) {
            int i = this.c;
            while (true) {
                ByteBuffer first = this.f3056a.getFirst();
                if (i < first.remaining()) {
                    first.position(i + first.position());
                    break;
                }
                i -= first.remaining();
                first.position(first.position() + first.remaining());
                if (!a(first)) {
                    break;
                }
            }
            a(this.c);
            this.c = 0;
        }
    }

    private boolean a(ByteBuffer byteBuffer) {
        if (this.f3056a.size() == 1) {
            if (this.b >= 0) {
                byteBuffer.position(0);
                byteBuffer.limit(0);
                this.b = byteBuffer.capacity();
                return false;
            }
            this.f3056a.removeFirst();
            return false;
        }
        this.f3056a.removeFirst();
        return true;
    }

    private void b(int i) {
        int i2 = 0;
        Iterator<ByteBuffer> it = this.f3056a.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                ByteBuffer next = it.next();
                if (i <= next.remaining()) {
                    int position = next.position();
                    next.get(this.d, i3, i);
                    next.position(position);
                    return;
                }
                int remaining = next.remaining();
                int position2 = next.position();
                next.get(this.d, i3, remaining);
                next.position(position2);
                i -= remaining;
                i2 = i3 + remaining;
            } else {
                throw new EndOfBufferException();
            }
        }
    }

    private ByteBuffer c(int i) {
        ByteBuffer byteBuffer;
        try {
            byteBuffer = this.f3056a.getFirst();
        } catch (NoSuchElementException e) {
            byteBuffer = null;
        }
        if (byteBuffer == null) {
            throw new EndOfBufferException();
        }
        if (i <= byteBuffer.remaining()) {
            this.c = i;
            return byteBuffer;
        }
        b(i);
        this.c = i;
        return this.e;
    }

    @Override // org.msgpack.io.e
    public byte d() {
        ByteBuffer c = c(1);
        return c.get(c.position());
    }

    @Override // org.msgpack.io.e
    public short e() {
        ByteBuffer c = c(2);
        return c.getShort(c.position());
    }

    @Override // org.msgpack.io.e
    public int f() {
        ByteBuffer c = c(4);
        return c.getInt(c.position());
    }

    @Override // org.msgpack.io.e
    public long g() {
        ByteBuffer c = c(8);
        return c.getLong(c.position());
    }

    @Override // org.msgpack.io.e
    public float h() {
        ByteBuffer c = c(4);
        return c.getFloat(c.position());
    }

    @Override // org.msgpack.io.e
    public double i() {
        ByteBuffer c = c(8);
        return c.getDouble(c.position());
    }

    public void a(byte[] bArr, int i, int i2, boolean z) {
        ByteBuffer byteBuffer;
        if (z) {
            if (this.b > 0 && this.f3056a.getLast().remaining() == 0) {
                this.f3056a.add(this.f3056a.size() - 1, ByteBuffer.wrap(bArr, i, i2));
                return;
            }
            this.f3056a.addLast(ByteBuffer.wrap(bArr, i, i2));
            this.b = -1;
            return;
        }
        try {
            byteBuffer = this.f3056a.getLast();
        } catch (NoSuchElementException e) {
            byteBuffer = null;
        }
        if (i2 <= this.b) {
            int position = byteBuffer.position();
            byteBuffer.position(byteBuffer.limit());
            byteBuffer.limit(byteBuffer.limit() + i2);
            byteBuffer.put(bArr, i, i2);
            byteBuffer.position(position);
            this.b = byteBuffer.capacity() - byteBuffer.limit();
            return;
        }
        if (this.b > 0) {
            int position2 = byteBuffer.position();
            byteBuffer.position(byteBuffer.limit());
            byteBuffer.limit(byteBuffer.limit() + this.b);
            byteBuffer.put(bArr, i, this.b);
            byteBuffer.position(position2);
            i += this.b;
            i2 -= this.b;
            this.b = 0;
        }
        int max = Math.max(i2, this.f);
        ByteBuffer allocate = ByteBuffer.allocate(max);
        allocate.put(bArr, i, i2);
        allocate.limit(i2);
        allocate.position(0);
        this.f3056a.addLast(allocate);
        this.b = max - i2;
    }

    public void j() {
        if (this.b >= 0) {
            ByteBuffer last = this.f3056a.getLast();
            this.f3056a.clear();
            last.position(0);
            last.limit(0);
            this.f3056a.addLast(last);
            this.b = last.capacity();
            return;
        }
        this.f3056a.clear();
        this.b = -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
