package com.kwai.filedownloader.message;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: com.kwai.filedownloader.message.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1156a extends MessageSnapshot implements a {

        /* renamed from: b  reason: collision with root package name */
        private final MessageSnapshot f10948b;

        public C1156a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.m());
            if (messageSnapshot.b() != -3) {
                throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b())));
            }
            this.f10948b = messageSnapshot;
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 4;
        }

        @Override // com.kwai.filedownloader.message.a
        public MessageSnapshot g_() {
            return this.f10948b;
        }
    }

    MessageSnapshot g_();
}
