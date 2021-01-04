package com.kwai.filedownloader.message;
/* loaded from: classes5.dex */
public interface a {

    /* renamed from: com.kwai.filedownloader.message.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1132a extends MessageSnapshot implements a {

        /* renamed from: b  reason: collision with root package name */
        private final MessageSnapshot f11247b;

        public C1132a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.m());
            if (messageSnapshot.b() != -3) {
                throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b())));
            }
            this.f11247b = messageSnapshot;
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 4;
        }

        @Override // com.kwai.filedownloader.message.a
        public MessageSnapshot g_() {
            return this.f11247b;
        }
    }

    MessageSnapshot g_();
}
