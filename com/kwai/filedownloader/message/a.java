package com.kwai.filedownloader.message;
/* loaded from: classes6.dex */
public interface a {

    /* renamed from: com.kwai.filedownloader.message.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0461a extends MessageSnapshot implements a {

        /* renamed from: b  reason: collision with root package name */
        public final MessageSnapshot f37337b;

        public C0461a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.m());
            if (messageSnapshot.b() != -3) {
                throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b())));
            }
            this.f37337b = messageSnapshot;
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 4;
        }

        @Override // com.kwai.filedownloader.message.a
        public MessageSnapshot g_() {
            return this.f37337b;
        }
    }

    MessageSnapshot g_();
}
