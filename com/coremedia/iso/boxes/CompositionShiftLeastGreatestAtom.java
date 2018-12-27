package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes5.dex */
public class CompositionShiftLeastGreatestAtom extends AbstractFullBox {
    public static final String TYPE = "cslg";
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0402a ajc$tjp_9 = null;
    int compositionOffsetToDisplayOffsetShift;
    int displayEndTime;
    int displayStartTime;
    int greatestDisplayOffset;
    int leastDisplayOffset;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("CompositionShiftLeastGreatestAtom.java", CompositionShiftLeastGreatestAtom.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getCompositionOffsetToDisplayOffsetShift", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "", "", "", "int"), 66);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "setCompositionOffsetToDisplayOffsetShift", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "int", "compositionOffsetToDisplayOffsetShift", "", "void"), 70);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getLeastDisplayOffset", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "", "", "", "int"), 74);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "setLeastDisplayOffset", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "int", "leastDisplayOffset", "", "void"), 78);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "getGreatestDisplayOffset", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "", "", "", "int"), 82);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "setGreatestDisplayOffset", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "int", "greatestDisplayOffset", "", "void"), 86);
        ajc$tjp_6 = bVar.a("method-execution", bVar.b("1", "getDisplayStartTime", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "", "", "", "int"), 90);
        ajc$tjp_7 = bVar.a("method-execution", bVar.b("1", "setDisplayStartTime", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "int", "displayStartTime", "", "void"), 94);
        ajc$tjp_8 = bVar.a("method-execution", bVar.b("1", "getDisplayEndTime", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "", "", "", "int"), 98);
        ajc$tjp_9 = bVar.a("method-execution", bVar.b("1", "setDisplayEndTime", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "int", "displayEndTime", "", "void"), 102);
    }

    public CompositionShiftLeastGreatestAtom() {
        super(TYPE);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 24L;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.compositionOffsetToDisplayOffsetShift = byteBuffer.getInt();
        this.leastDisplayOffset = byteBuffer.getInt();
        this.greatestDisplayOffset = byteBuffer.getInt();
        this.displayStartTime = byteBuffer.getInt();
        this.displayEndTime = byteBuffer.getInt();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.putInt(this.compositionOffsetToDisplayOffsetShift);
        byteBuffer.putInt(this.leastDisplayOffset);
        byteBuffer.putInt(this.greatestDisplayOffset);
        byteBuffer.putInt(this.displayStartTime);
        byteBuffer.putInt(this.displayEndTime);
    }

    public int getCompositionOffsetToDisplayOffsetShift() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.compositionOffsetToDisplayOffsetShift;
    }

    public void setCompositionOffsetToDisplayOffsetShift(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.zr(i)));
        this.compositionOffsetToDisplayOffsetShift = i;
    }

    public int getLeastDisplayOffset() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.leastDisplayOffset;
    }

    public void setLeastDisplayOffset(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, org.aspectj.a.a.a.zr(i)));
        this.leastDisplayOffset = i;
    }

    public int getGreatestDisplayOffset() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.greatestDisplayOffset;
    }

    public void setGreatestDisplayOffset(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, org.aspectj.a.a.a.zr(i)));
        this.greatestDisplayOffset = i;
    }

    public int getDisplayStartTime() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        return this.displayStartTime;
    }

    public void setDisplayStartTime(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this, org.aspectj.a.a.a.zr(i)));
        this.displayStartTime = i;
    }

    public int getDisplayEndTime() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this));
        return this.displayEndTime;
    }

    public void setDisplayEndTime(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_9, this, this, org.aspectj.a.a.a.zr(i)));
        this.displayEndTime = i;
    }
}
