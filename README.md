Pokemon-Randomizer
==================

Randomizer for Pokemon Gold/Silver/Crystal roms

This was a side project I worked on while on summer break one year. The concept here is simple - take in a pokemon G/S/C rom, and spit out a playable version of the game where aspects of the game have been altered. For example running into a level 2 Lugia in the bushes just outside of New Bark Town. And then that Lugia uses Horn Drill and OHKOs your only pokemon. Once the rom was randomized we would distribute the new rom among a bunch of people, and then race to the finish, without knowing what would possibly come next. Who could learn what HMs, etc.. It was a blast.

The idea is that the rom is very well structured, if you know where the addresses for the various pokemon are then you can just go in there and swap out a 0x27 with a 0x56, and bam - that jigglypuff just turned into a seel. It involved another community on an IRC Network, and the help of a man named padz over at #skeetendo on NoLimitNET. The community there had been disassembling the pokemon rom for a very long time, but were still missing a few key things here and there, like where pokemon are pulled from when you fish. We eventually found the banks and finished up his research, and then I took the knowledge from that, and put together a randomizer.

This was one of the strangest projects I've ever worked on, but set the stage for me to perform well in GBA code later on in CS 2110.
