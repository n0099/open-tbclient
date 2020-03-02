package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] nmh = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] nmi;
    public static final /* synthetic */ int[] nmj;

    static {
        nmh[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        nmh[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        nmh[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        nmh[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        nmi = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        nmi[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        nmi[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        nmi[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        nmj = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        nmj[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        nmj[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        nmj[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
