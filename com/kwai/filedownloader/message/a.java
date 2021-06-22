package com.kwai.filedownloader.message;
/* loaded from: classes7.dex */
public interface a {

    /* renamed from: com.kwai.filedownloader.message.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0450a extends MessageSnapshot implements a {

        /* renamed from: b  reason: collision with root package name */
        public final MessageSnapshot f37910b;

        public C0450a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.m());
            if (messageSnapshot.b() != -3) {
                throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b())));
            }
            this.f37910b = messageSnapshot;
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 4;
        }

        @Override // com.kwai.filedownloader.message.a
        public MessageSnapshot g_() {
            return this.f37910b;
        }
    }

    MessageSnapshot g_();
}
