ツール詳細
--
プログラミングコンテストの問題を解く際のアシストツールです．(対象：Java言語)

問題のSampleInputファイルを自動的に読み込み，プログラムへ入力する機能を提供します．Outputをテストするための機能も提供します．


使い方
--
まず，入力例を SampleInput/ に，出力例を SampleOutput/ に，同名ファイルで作成します．
あとは test.Test クラスを呼ぶだけです．


使用例1．プログラムの実行(入力例を入力値とする)

```
System.out.print(test.Test.exec("クラス名", "ファイル名"));
```

注：プログラムの出力は文字列として帰ってきます．

使用例2．入力例，プログラムの出力，出力例をコンソールに出力

```
System.out.print(test.Test.execResult("クラス名
","ファイル名"));
```


使用例3．プログラムの出力が出力例と一致するか確認

- JUnitを使う場合

```
	assertEquals(test.Test.readFile("ファイル名"), test.Test.exec("クラス名", "ファイル名"));
```

- JUnitを使わない場合

出力例は ``` test.Test.readFile("ファイル名") ``` で，プログラムの出力は ``` test.Test.exec("クラス名", "ファイル名") ``` で文字列として取得できるので，てきとうに使ってください．


```
  if ( test.Test.readFile("ファイル名").equals(test.Test.exec("クラス名", "ファイル名"))) {
}
```