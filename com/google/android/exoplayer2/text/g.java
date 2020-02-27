package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public interface g {
    public static final g myI = new g() { // from class: com.google.android.exoplayer2.text.g.1
        @Override // com.google.android.exoplayer2.text.g
        public boolean i(Format format) {
            String str = format.sampleMimeType;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str);
        }

        @Override // com.google.android.exoplayer2.text.g
        public f p(Format format) {
            String str = format.sampleMimeType;
            char c = 65535;
            switch (str.hashCode()) {
                case -1351681404:
                    if (str.equals("application/dvbsubs")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1026075066:
                    if (str.equals("application/x-mp4-vtt")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1004728940:
                    if (str.equals("text/vtt")) {
                        c = 0;
                        break;
                    }
                    break;
                case 691401887:
                    if (str.equals("application/x-quicktime-tx3g")) {
                        c = 5;
                        break;
                    }
                    break;
                case 822864842:
                    if (str.equals("text/x-ssa")) {
                        c = 1;
                        break;
                    }
                    break;
                case 930165504:
                    if (str.equals("application/x-mp4-cea-608")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1566015601:
                    if (str.equals("application/cea-608")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1566016562:
                    if (str.equals("application/cea-708")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1668750253:
                    if (str.equals("application/x-subrip")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1693976202:
                    if (str.equals("application/ttml+xml")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return new com.google.android.exoplayer2.text.g.g();
                case 1:
                    return new com.google.android.exoplayer2.text.c.a(format.initializationData);
                case 2:
                    return new com.google.android.exoplayer2.text.g.b();
                case 3:
                    return new com.google.android.exoplayer2.text.e.a();
                case 4:
                    return new com.google.android.exoplayer2.text.d.a();
                case 5:
                    return new com.google.android.exoplayer2.text.f.a(format.initializationData);
                case 6:
                case 7:
                    return new com.google.android.exoplayer2.text.a.a(format.sampleMimeType, format.accessibilityChannel);
                case '\b':
                    return new com.google.android.exoplayer2.text.a.c(format.accessibilityChannel);
                case '\t':
                    return new com.google.android.exoplayer2.text.b.a(format.initializationData);
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }
    };

    boolean i(Format format);

    f p(Format format);
}
