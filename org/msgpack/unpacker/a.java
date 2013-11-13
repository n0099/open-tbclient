package org.msgpack.unpacker;

import java.nio.ByteBuffer;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
abstract class a implements org.msgpack.io.b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2969a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) {
        this.f2969a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        throw new MessageTypeException(String.format("Expected %s, but got boolean", this.f2969a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte b) {
        throw new MessageTypeException(String.format("Expected %s, but got integer value", this.f2969a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(short s) {
        throw new MessageTypeException(String.format("Expected %s, but got integer value", this.f2969a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        throw new MessageTypeException(String.format("Expected %s, but got integer value", this.f2969a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        throw new MessageTypeException(String.format("Expected %s, but got integer value", this.f2969a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(byte b) {
        throw new MessageTypeException(String.format("Expected %s, but got integer value", this.f2969a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(short s) {
        throw new MessageTypeException(String.format("Expected %s, but got integer value", this.f2969a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        throw new MessageTypeException(String.format("Expected %s, but got integer value", this.f2969a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j) {
        throw new MessageTypeException(String.format("Expected %s, but got integer value", this.f2969a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr) {
        throw new MessageTypeException(String.format("Expected %s, but got raw value", this.f2969a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        throw new MessageTypeException(String.format("Expected %s, but got raw value", this.f2969a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        throw new MessageTypeException(String.format("Expected %s, but got array value", this.f2969a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i) {
        throw new MessageTypeException(String.format("Expected %s, but got map value", this.f2969a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        throw new MessageTypeException(String.format("Expected %s, but got nil value", this.f2969a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        throw new MessageTypeException(String.format("Expected %s, but got float value", this.f2969a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(double d) {
        throw new MessageTypeException(String.format("Expected %s, but got float value", this.f2969a));
    }

    @Override // org.msgpack.io.b
    public void a(ByteBuffer byteBuffer, boolean z) {
        throw new MessageTypeException(String.format("Expected %s, but got raw value", this.f2969a));
    }
}
