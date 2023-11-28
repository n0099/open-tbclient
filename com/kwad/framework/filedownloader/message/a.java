package com.kwad.framework.filedownloader.message;
/* loaded from: classes10.dex */
public interface a {
    MessageSnapshot vN();

    /* renamed from: com.kwad.framework.filedownloader.message.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0684a extends MessageSnapshot implements a {
        public final MessageSnapshot agW;

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte tL() {
            return (byte) 4;
        }

        public C0684a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.getId());
            if (messageSnapshot.tL() == -3) {
                this.agW = messageSnapshot;
                return;
            }
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.b("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.tL())));
        }

        @Override // com.kwad.framework.filedownloader.message.a
        public final MessageSnapshot vN() {
            return this.agW;
        }
    }
}
