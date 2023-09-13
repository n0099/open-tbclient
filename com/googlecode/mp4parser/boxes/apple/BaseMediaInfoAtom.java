package com.googlecode.mp4parser.boxes.apple;

import com.baidu.ar.gesture.GestureAR;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes10.dex */
public class BaseMediaInfoAtom extends AbstractFullBox {
    public static final String TYPE = "gmin";
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_10 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_11 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_12 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_6 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_7 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_8 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_9 = null;
    public short balance;
    public short graphicsMode;
    public int opColorB;
    public int opColorG;
    public int opColorR;
    public short reserved;

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return 16L;
    }

    static {
        ajc$preClinit();
    }

    public BaseMediaInfoAtom() {
        super(TYPE);
        this.graphicsMode = (short) 64;
        this.opColorR = 32768;
        this.opColorG = 32768;
        this.opColorB = 32768;
    }

    public short getBalance() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_8, this, this));
        return this.balance;
    }

    public short getGraphicsMode() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
        return this.graphicsMode;
    }

    public int getOpColorB() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_6, this, this));
        return this.opColorB;
    }

    public int getOpColorG() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
        return this.opColorG;
    }

    public int getOpColorR() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
        return this.opColorR;
    }

    public short getReserved() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_10, this, this));
        return this.reserved;
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("BaseMediaInfoAtom.java", BaseMediaInfoAtom.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getGraphicsMode", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "short"), 54);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setGraphicsMode", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "short", "graphicsMode", "", "void"), 58);
        ajc$tjp_10 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getReserved", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "short"), 94);
        ajc$tjp_11 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setReserved", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "short", GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED, "", "void"), 98);
        ajc$tjp_12 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "java.lang.String"), 103);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getOpColorR", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "int"), 62);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setOpColorR", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "int", "opColorR", "", "void"), 66);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getOpColorG", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "int"), 70);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setOpColorG", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "int", "opColorG", "", "void"), 74);
        ajc$tjp_6 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getOpColorB", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "int"), 78);
        ajc$tjp_7 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setOpColorB", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "int", "opColorB", "", "void"), 82);
        ajc$tjp_8 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getBalance", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "short"), 86);
        ajc$tjp_9 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setBalance", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "short", "balance", "", "void"), 90);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.graphicsMode = byteBuffer.getShort();
        this.opColorR = IsoTypeReader.readUInt16(byteBuffer);
        this.opColorG = IsoTypeReader.readUInt16(byteBuffer);
        this.opColorB = IsoTypeReader.readUInt16(byteBuffer);
        this.balance = byteBuffer.getShort();
        this.reserved = byteBuffer.getShort();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.putShort(this.graphicsMode);
        IsoTypeWriter.writeUInt16(byteBuffer, this.opColorR);
        IsoTypeWriter.writeUInt16(byteBuffer, this.opColorG);
        IsoTypeWriter.writeUInt16(byteBuffer, this.opColorB);
        byteBuffer.putShort(this.balance);
        byteBuffer.putShort(this.reserved);
    }

    public void setBalance(short s) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_9, this, this, Conversions.shortObject(s)));
        this.balance = s;
    }

    public void setGraphicsMode(short s) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, Conversions.shortObject(s)));
        this.graphicsMode = s;
    }

    public void setOpColorB(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_7, this, this, Conversions.intObject(i)));
        this.opColorB = i;
    }

    public void setOpColorG(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this, Conversions.intObject(i)));
        this.opColorG = i;
    }

    public void setOpColorR(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, Conversions.intObject(i)));
        this.opColorR = i;
    }

    public void setReserved(short s) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_11, this, this, Conversions.shortObject(s)));
        this.reserved = s;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_12, this, this));
        return "BaseMediaInfoAtom{graphicsMode=" + ((int) this.graphicsMode) + ", opColorR=" + this.opColorR + ", opColorG=" + this.opColorG + ", opColorB=" + this.opColorB + ", balance=" + ((int) this.balance) + ", reserved=" + ((int) this.reserved) + '}';
    }
}
