package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class i {
    public static final a.InterfaceC0670a mdv = new a.InterfaceC0670a() { // from class: com.google.android.exoplayer2.extractor.i.1
        @Override // com.google.android.exoplayer2.metadata.id3.a.InterfaceC0670a
        public boolean h(int i, int i2, int i3, int i4, int i5) {
            return i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2);
        }
    };
    private static final Pattern mdw = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int encoderDelay = -1;
    public int encoderPadding = -1;

    public boolean Jw(int i) {
        int i2 = i >> 12;
        int i3 = i & 4095;
        if (i2 > 0 || i3 > 0) {
            this.encoderDelay = i2;
            this.encoderPadding = i3;
            return true;
        }
        return false;
    }

    public boolean c(Metadata metadata) {
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry Ka = metadata.Ka(i);
            if (Ka instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) Ka;
                if (ff(commentFrame.description, commentFrame.text)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean ff(String str, String str2) {
        if ("iTunSMPB".equals(str)) {
            Matcher matcher = mdw.matcher(str2);
            if (matcher.find()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1), 16);
                    int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                    if (parseInt > 0 || parseInt2 > 0) {
                        this.encoderDelay = parseInt;
                        this.encoderPadding = parseInt2;
                        return true;
                    }
                    return false;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    public boolean dtG() {
        return (this.encoderDelay == -1 || this.encoderPadding == -1) ? false : true;
    }
}
