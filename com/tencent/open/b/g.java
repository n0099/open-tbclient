jadx.core.utils.exceptions.JadxRuntimeException: Failed to generate code for class: com.tencent.open.b.g
	at jadx.core.ProcessClass.generateCode(ProcessClass.java:121)
	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:384)
	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:332)
Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code generation error after restart
	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:52)
	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
	at jadx.core.ProcessClass.process(ProcessClass.java:77)
	at jadx.core.ProcessClass.generateCode(ProcessClass.java:115)
	... 2 more
Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:309)
	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: INVOKE  
  (wrap: java.lang.Runnable : 0x0007: CONSTRUCTOR  (r0v0 java.lang.Runnable A[REMOVE]) = 
  (r6v0 'this' com.tencent.open.b.g A[IMMUTABLE_TYPE, THIS])
  (r9v0 'bundle' android.os.Bundle A[DONT_INLINE])
  (r7v0 'str' java.lang.String A[DONT_INLINE])
  (r10v0 'z' boolean A[DONT_INLINE])
  (r8v0 'str2' java.lang.String A[DONT_INLINE])
 call: com.tencent.open.b.g.6.<init>(com.tencent.open.b.g, android.os.Bundle, java.lang.String, boolean, java.lang.String):void type: CONSTRUCTOR)
 type: STATIC call: com.tencent.open.utils.i.a(java.lang.Runnable):void in method: com.tencent.open.b.g.a(java.lang.String, java.lang.String, android.os.Bundle, boolean):void, file: classes19.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:287)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.dex.regions.Region.generate(Region.java:35)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
	... 5 more
Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:309)
	... 5 more
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0118: IF  (r1v19 'i2' int) >= (r4v1 'i' int)  -> B:59:0x011a in method: com.tencent.open.b.g.6.run():void, file: classes19.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:287)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.dex.regions.Region.generate(Region.java:35)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.dex.regions.Region.generate(Region.java:35)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.dex.regions.Region.generate(Region.java:35)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.dex.regions.Region.generate(Region.java:35)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:302)
	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.dex.regions.Region.generate(Region.java:35)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
	... 5 more
Caused by: jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:664)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:522)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:280)
	... 31 more

