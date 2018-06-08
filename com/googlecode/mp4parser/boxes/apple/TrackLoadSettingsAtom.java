package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public class TrackLoadSettingsAtom extends AbstractBox {
    public static final String TYPE = "load";
    private static final /* synthetic */ a.InterfaceC0296a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0296a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0296a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0296a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0296a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0296a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0296a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0296a ajc$tjp_7 = null;
    int defaultHints;
    int preloadDuration;
    int preloadFlags;
    int preloadStartTime;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrackLoadSettingsAtom.java", TrackLoadSettingsAtom.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getPreloadStartTime", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "", "", "", "int"), 49);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "setPreloadStartTime", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "int", "preloadStartTime", "", "void"), 53);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getPreloadDuration", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "", "", "", "int"), 57);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "setPreloadDuration", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "int", "preloadDuration", "", "void"), 61);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "getPreloadFlags", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "", "", "", "int"), 65);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "setPreloadFlags", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "int", "preloadFlags", "", "void"), 69);
        ajc$tjp_6 = bVar.a("method-execution", bVar.b("1", "getDefaultHints", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "", "", "", "int"), 73);
        ajc$tjp_7 = bVar.a("method-execution", bVar.b("1", "setDefaultHints", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "int", "defaultHints", "", "void"), 77);
    }

    public TrackLoadSettingsAtom() {
        super(TYPE);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 16L;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.preloadStartTime);
        byteBuffer.putInt(this.preloadDuration);
        byteBuffer.putInt(this.preloadFlags);
        byteBuffer.putInt(this.defaultHints);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        this.preloadStartTime = byteBuffer.getInt();
        this.preloadDuration = byteBuffer.getInt();
        this.preloadFlags = byteBuffer.getInt();
        this.defaultHints = byteBuffer.getInt();
    }

    public int getPreloadStartTime() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.preloadStartTime;
    }

    public void setPreloadStartTime(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.wD(i)));
        this.preloadStartTime = i;
    }

    public int getPreloadDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.preloadDuration;
    }

    public void setPreloadDuration(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, org.aspectj.a.a.a.wD(i)));
        this.preloadDuration = i;
    }

    public int getPreloadFlags() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.preloadFlags;
    }

    public void setPreloadFlags(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, org.aspectj.a.a.a.wD(i)));
        this.preloadFlags = i;
    }

    public int getDefaultHints() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        return this.defaultHints;
    }

    public void setDefaultHints(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this, org.aspectj.a.a.a.wD(i)));
        this.defaultHints = i;
    }
}
