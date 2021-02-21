package com.kwai.filedownloader.message;
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: com.kwai.filedownloader.message.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1162a extends MessageSnapshot implements a {

        /* renamed from: b  reason: collision with root package name */
        private final MessageSnapshot f10950b;

        public C1162a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.m());
            if (messageSnapshot.b() != -3) {
                throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b())));
            }
            this.f10950b = messageSnapshot;
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 4;
        }

        @Override // com.kwai.filedownloader.message.a
        public MessageSnapshot g_() {
            return this.f10950b;
        }
    }

    MessageSnapshot g_();
}
