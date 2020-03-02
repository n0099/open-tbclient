package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public interface b {
    public static final b mqk = new b() { // from class: com.google.android.exoplayer2.metadata.b.1
        @Override // com.google.android.exoplayer2.metadata.b
        public boolean i(Format format) {
            String str = format.sampleMimeType;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str);
        }

        @Override // com.google.android.exoplayer2.metadata.b
        public a j(Format format) {
            String str = format.sampleMimeType;
            char c = 65535;
            switch (str.hashCode()) {
                case -1248341703:
                    if (str.equals("application/id3")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1154383568:
                    if (str.equals("application/x-emsg")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1652648887:
                    if (str.equals("application/x-scte35")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return new com.google.android.exoplayer2.metadata.id3.a();
                case 1:
                    return new com.google.android.exoplayer2.metadata.emsg.a();
                case 2:
                    return new com.google.android.exoplayer2.metadata.scte35.a();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }
    };

    boolean i(Format format);

    a j(Format format);
}
